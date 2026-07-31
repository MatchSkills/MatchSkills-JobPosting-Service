package com.matchskills.jobposting.service.entitys;

import com.matchskills.jobposting.service.domains.JobPostingDomain;
import com.matchskills.jobposting.service.dtos.JobPostingResponse;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "jobposts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class JobPostingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long companyId;
    private String title;
    private String description;
    private String local;
    private LocalDate createAt;

    public JobPostingDomain toJobPostingDomain(){
        return new JobPostingDomain(this.id,this.companyId,this.title,this.description,this.local,this.createAt);
    }

    public JobPostingResponse toJobPostingResponse(){
        return new JobPostingResponse(this.id,this.companyId,this.title,this.description,this.local,this.createAt);
    }

}
