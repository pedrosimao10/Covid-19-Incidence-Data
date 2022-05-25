package com.uatqs.hw1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;

public class ErrorController {

    private final Logger logger = LoggerFactory.getLogger(ErrorController.class);   //logging strategy
    
    @RequestMapping("/error")
    public String handleError() {
        logger.info("(AppController.java) Error! Country/ISO not found.");
        return "error";
    }
}
