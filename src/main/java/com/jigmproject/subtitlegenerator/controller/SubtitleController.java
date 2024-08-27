package com.jigmproject.subtitlegenerator.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jigmproject.subtitlegenerator.entity.Subtitle;
import com.jigmproject.subtitlegenerator.service.SubtitleService;

@RestController  // REST API를 처리하는 컨트롤러임을 명시
@RequestMapping("/api/subtitles")  // 기본 URL 패스 설정
public class SubtitleController {

    private final SubtitleService subtitleService;

    @Autowired  // 생성자에 의존성 주입
    public SubtitleController(SubtitleService subtitleService) {
        this.subtitleService = subtitleService;
    }

    // URL을 통해 자막 생성 요청 처리
    @GetMapping("/from-url")
    public Subtitle generateSubtitleFromUrl(@RequestParam String videoUrl) {
        return subtitleService.generateSubtitleFromUrl(videoUrl);
    }

    // 파일을 통해 자막 생성 요청 처리
    @PostMapping("/from-file")
    public Subtitle generateSubtitleFromFile(@RequestParam("file") MultipartFile file) {
        try {
            // 업로드된 파일을 임시 파일로 변환하여 저장
            File convFile = File.createTempFile("upload_", "_" + file.getOriginalFilename());
            file.transferTo(convFile);

            // 생성된 파일을 사용하여 자막 생성
            return subtitleService.generateSubtitleFromFile(convFile);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File upload failed: " + e.getMessage());  // 파일 업로드 실패 시 예외 발생
        }
    }

    // 오브젝트 스토리지 키를 통해 자막 생성 요청 처리
    @GetMapping("/from-object-storage")
    public Subtitle generateSubtitleFromObjectStorage(@RequestParam String dataKey) {
        return subtitleService.generateSubtitleFromObjectStorage(dataKey);
    }

    // ID를 통해 자막 조회 요청 처리
    @GetMapping("/{id}")
    public Subtitle getSubtitleById(@PathVariable Long id) {
        return subtitleService.getSubtitleById(id);
    }
}
