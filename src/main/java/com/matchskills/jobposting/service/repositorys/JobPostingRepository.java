package com.matchskills.jobposting.service.repositorys;

import com.matchskills.jobposting.service.entitys.JobPostingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPostingEntity, Long> {
}
