package com.matchskills.jobposting.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class EditJobPostingRequest {

    private String title;
    private String description;
    private String local;

}
