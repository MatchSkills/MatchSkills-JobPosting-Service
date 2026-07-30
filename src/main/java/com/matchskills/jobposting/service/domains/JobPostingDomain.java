package com.matchskills.jobposting.service.domains;

import com.matchskills.jobposting.service.dtos.JobPostingResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class JobPostingDomain {

    private Long id;
    private Long companyId;
    private String title;
    private String description;
    private String local;
    private LocalDate createAt;

    public JobPostingResponse toJobPostingResponse(){
        return new JobPostingResponse(this.id,this.companyId,this.title,this.description,this.local,this.createAt);
    }

}
