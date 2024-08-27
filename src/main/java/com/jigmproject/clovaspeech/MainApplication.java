package com.jigmproject.clovaspeech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jigmproject.subtitlegenerator.entity.Subtitle;
import com.jigmproject.subtitlegenerator.service.SubtitleService;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        // 스프링 애플리케이션 컨텍스트 시작
        ApplicationContext context = SpringApplication.run(MainApplication.class, args);

        // SubtitleService 빈 가져오기
        SubtitleService subtitleService = context.getBean(SubtitleService.class);

        // 처리할 비디오 URL
        String videoUrl = "YOUR_VIDEO_URL_HERE";  // 실제 비디오 URL을 여기에 입력

        // URL을 통해 자막 생성
        Subtitle subtitle = subtitleService.generateSubtitleFromUrl(videoUrl);

        // 생성된 자막 출력
        System.out.println("Generated Subtitle:");
        System.out.println(subtitle.getText());
    }
}
