package com.jigmproject.subtitlegenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/api/some-endpoint")
    public String someEndpoint() {
        return "API Response";
    }
}
