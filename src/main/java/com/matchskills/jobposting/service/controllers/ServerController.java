package com.matchskills.jobposting.service.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ServerController {

    @GetMapping
    public ResponseEntity<String> health(){
        return  ResponseEntity.ok("OK");
    }

}
