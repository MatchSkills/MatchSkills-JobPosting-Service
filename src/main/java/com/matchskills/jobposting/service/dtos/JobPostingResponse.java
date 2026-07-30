package com.matchskills.jobposting.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class JobPostingResponse {

    private Long id;
    private Long companyId;
    private String title;
    private String description;
    private String local;
    private LocalDate createAt;

}
