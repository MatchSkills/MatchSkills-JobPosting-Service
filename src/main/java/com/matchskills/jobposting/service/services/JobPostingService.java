package com.matchskills.jobposting.service.services;

import com.matchskills.jobposting.service.dtos.CreateJobPostingRequest;
import com.matchskills.jobposting.service.dtos.EditJobPostingRequest;
import com.matchskills.jobposting.service.dtos.JobPostingResponse;
import com.matchskills.jobposting.service.entitys.JobPostingEntity;
import com.matchskills.jobposting.service.exceptions.customs.jobposting.JobPostingNotFoundException;
import com.matchskills.jobposting.service.exceptions.customs.jobposting.NotJobPostingOwnerException;
import com.matchskills.jobposting.service.jwt.JwtService;
import com.matchskills.jobposting.service.repositorys.JobPostingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class JobPostingService {

    final private JobPostingRepository jobPostingRepository;
    final private JwtService jwtService;

    public JobPostingService(JobPostingRepository jobPostingRepository, JwtService jwtService) {
        this.jobPostingRepository = jobPostingRepository;
        this.jwtService = jwtService;
    }

    public Page<JobPostingResponse> getAllJobPostingByCompanyId(Long id, Pageable pageable){
        return jobPostingRepository.findAllByCompanyId(
                id,
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        pageable.getSortOr(Sort.by(Sort.Direction.ASC,"id"))
                )
        ).map(JobPostingEntity::toJobPostingResponse);

    }

    public JobPostingResponse createJob(CreateJobPostingRequest createJobPostRequest) {

        var newJobPost = JobPostingEntity.builder()
                .companyId(createJobPostRequest.getCompanyId())
                .title(createJobPostRequest.getTitle())
                .description(createJobPostRequest.getDescription())
                .local(createJobPostRequest.getLocal())
                .targetHardskills(createJobPostRequest.getTargetHardskills())
                .targetSoftskills(createJobPostRequest.getTargetSoftskills())
                .build();

        var savedJobPost = jobPostingRepository.save(newJobPost);

        return savedJobPost.toJobPostingDomain().toJobPostingResponse();

    }

    public JobPostingResponse editJob(EditJobPostingRequest editJobPostingRequest, Long id, String token){

        token = jwtService.getToken(token);

        var decodedToken = jwtService.decodeToken(token);

        var targetJobPosting = jobPostingRepository.findById(id)
                .orElseThrow(JobPostingNotFoundException::new);

        if (!targetJobPosting.getCompanyId().equals(decodedToken.getUserId())){
            throw new NotJobPostingOwnerException();
        }

        targetJobPosting.setTitle(editJobPostingRequest.getTitle());
        targetJobPosting.setDescription(editJobPostingRequest.getDescription());
        targetJobPosting.setLocal(editJobPostingRequest.getLocal());

        var savedJobPosting = jobPostingRepository.save(targetJobPosting);

        return savedJobPosting.toJobPostingDomain().toJobPostingResponse();

    }

    public void deletejob(Long id, String token){

        token = jwtService.getToken(token);

        var decodedToken = jwtService.decodeToken(token);

        var targetJobPosting = jobPostingRepository.findById(id)
                .orElseThrow(JobPostingNotFoundException::new);

        if (!targetJobPosting.getCompanyId().equals(decodedToken.getUserId())){
            throw new NotJobPostingOwnerException();
        }

        jobPostingRepository.deleteById(targetJobPosting.getId());

    }

}
