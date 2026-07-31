package com.matchskills.jobposting.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class AddSoftSkillsJobPostingRequest {

    private Map<String, Integer> targetSoftskills;

}
