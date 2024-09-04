package com.jigmproject.subtitlegenerator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.jigmproject.clovaspeech.ClovaSpeechClient;

@Configuration
public class AppConfig {

    @Bean
    public ClovaSpeechClient clovaSpeechClient(@Value("${clova.speech.api.key}") String secret,
                                               @Value("${clova.speech.api.url}") String invokeUrl) {
        return new ClovaSpeechClient(secret, invokeUrl);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
