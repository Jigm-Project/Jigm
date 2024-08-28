package com.jigmproject.subtitlegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jigmproject.subtitlegenerator", "com.jigmproject.clovaspeech"})
public class SubtitleGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(SubtitleGeneratorApplication.class, args);
    }
}