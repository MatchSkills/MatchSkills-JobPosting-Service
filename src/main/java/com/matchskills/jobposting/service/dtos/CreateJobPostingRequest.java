package com.matchskills.jobposting.service.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class CreateJobPostingRequest {

    private Long companyId;

    @Size(max = 150, message = "The title must be max size of 150 characters.")
    @NotBlank(message = "JobPost must have a title")
    private String title;

    @Size(max = 500, message = "The description must be max size of 500 characters.")
    @NotBlank(message = "JobPost must have a description")
    private String description;

    @Size(max = 500, message = "The local must be max size of 500 characters.")
    @NotBlank(message = "JobPost must have a local")
    private String local;

    @Size(max = 255, message = "The hardskills must be max size of 255 characters.")
    @NotNull(message = "JobPost must have a target hardskills")
    private List<String> targetHardskills;

    private Map<String, Integer> targetSoftskills;

}
