package com.matchskills.jobposting.service.controllers;

import com.matchskills.jobposting.service.dtos.CreateJobPostingRequest;
import com.matchskills.jobposting.service.dtos.EditJobPostingRequest;
import com.matchskills.jobposting.service.dtos.JobPostingResponse;
import com.matchskills.jobposting.service.services.JobPostingService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobPostingController {

    final private JobPostingService jobPostingService;

    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }


    @GetMapping("/company/{id}")
    public ResponseEntity<Page<JobPostingResponse>> getJobPostByCompanyId(@PathVariable Long id, Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostingService.getAllJobPostingByCompanyId(id, pageable));

    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('Company')")
    public ResponseEntity<JobPostingResponse> createJob(@Valid @RequestBody CreateJobPostingRequest createJobPostRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(jobPostingService.createJob(createJobPostRequest));
    }

    @PutMapping("/{id}/edit")
    @PreAuthorize("hasRole('Company')")
    public ResponseEntity<JobPostingResponse> editJob(@Valid  @RequestHeader("Authorization") String accesstoken, @RequestBody EditJobPostingRequest editJobPostRequest, @PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(jobPostingService.editJob(editJobPostRequest, id, accesstoken));

    }

    @DeleteMapping("/{id}/delete")
    @PreAuthorize("hasRole('Company')")
    public  ResponseEntity<Void> deleteJob(@PathVariable Long id, @RequestHeader("Authorization") String accesstoken){

        jobPostingService.deletejob(id, accesstoken);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
