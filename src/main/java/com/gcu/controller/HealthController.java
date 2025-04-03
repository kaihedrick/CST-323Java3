package com.gcu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/")
    public String home() {
        return "Application is running";
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }
}
