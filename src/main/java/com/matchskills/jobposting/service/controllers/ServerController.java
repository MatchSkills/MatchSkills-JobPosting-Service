package com.matchskills.jobposting.service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ServerController {

    @GetMapping
    public ResponseEntity<String> health(){
        return  ResponseEntity.ok("OK");
    }

    @GetMapping("test/company")
    @PreAuthorize("hasRole('Company')")
    public ResponseEntity<String> companyTest(){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("test/candidate")
    @PreAuthorize("hasRole('Candidate')")
    public ResponseEntity<String> cadidateTest(){
        return ResponseEntity.ok("OK");
    }

}
