package com.Jigm_Project.SubtitleGenerator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/hello")
    public String hello() {
        return "반갑당 집중포화조여, 이제 한수형이 하면 되는건가~";
    }
}