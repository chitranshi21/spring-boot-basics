package com.chitranshi21.springbootbasics.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class HomeController {

    @GetMapping("/")
    public String home() {
        log.info("home controller: ");
        return "home";
    }

    @GetMapping("/error")
    public String error() throws Exception {
        throw new Exception("Error while processing ");
    }
}
