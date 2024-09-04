package com.jigmproject.subtitlegenerator.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jigmproject.subtitlegenerator.entity.SubtitleEntity;
import com.jigmproject.subtitlegenerator.service.SubtitleService;

@RestController
@RequestMapping("/api/subtitles")
@CrossOrigin(origins = "http://localhost:3000")
public class SubtitleController {

    private final SubtitleService subtitleService;

    @Autowired
    public SubtitleController(SubtitleService subtitleService) {
        this.subtitleService = subtitleService;
    }

    // 파일을 통해 자막 생성 요청 처리
    @PostMapping("/upload")
    public ResponseEntity<SubtitleEntity> uploadFileAndGenerateSubtitleEntity(@RequestParam("file") MultipartFile file) {
        try {
            // 파일이 비었을 경우
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body(null);
            }

            // 파일을 통해 자막 생성
            SubtitleEntity subtitleEntity = subtitleService.generateSubtitleFromFile(file);

            if (subtitleEntity != null) {
                // 자막 생성 성공 시
                return ResponseEntity.ok(subtitleEntity);
            } else {
                // 자막 생성 실패 시
                return ResponseEntity.status(500).body(null);
            }
        } catch (IOException e) {
            // 파일 처리 중 발생한 IOException 처리
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        } catch (Exception e) {
            // 일반적인 예외 처리
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
