package com.cdac_project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/hello")
    public String hello() {
        logger.debug("GET /api/hello endpoint accessed");
        return "Hello World!";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        logger.info("POST /api/login endpoint accessed with username: {}, password: {}", username, password);
        
        // Your login logic here
        
        return "Login successful";
    }
}
