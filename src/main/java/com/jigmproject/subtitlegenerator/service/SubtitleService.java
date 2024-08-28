package com.jigmproject.subtitlegenerator.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jigmproject.clovaspeech.ClovaSpeechClient;
import com.jigmproject.subtitlegenerator.entity.Subtitle;
import com.jigmproject.subtitlegenerator.exception.ResourceNotFoundException;
import com.jigmproject.subtitlegenerator.repository.SubtitleRepository;

@Service  // 이 클래스가 서비스 레이어 역할을 한다고 스프링에 알림
public class SubtitleService {

    private final ClovaSpeechClient clovaSpeechClient;
    private final SubtitleRepository subtitleRepository;

    @Autowired  // 생성자에 의존성 주입
    public SubtitleService(ClovaSpeechClient clovaSpeechClient, SubtitleRepository subtitleRepository) {
        this.clovaSpeechClient = clovaSpeechClient;
        this.subtitleRepository = subtitleRepository;
    }

    // URL을 통해 자막 생성
    public Subtitle generateSubtitleFromUrl(String videoUrl) {
        String subtitleText = clovaSpeechClient.url(videoUrl, new ClovaSpeechClient.NestRequestEntity());
        Subtitle subtitle = Subtitle.builder()
                                    .text(subtitleText)
                                    .source(videoUrl)
                                    .build();
        return subtitleRepository.save(subtitle);  // 생성된 자막을 데이터베이스에 저장
    }

    // 파일을 통해 자막 생성
    public Subtitle generateSubtitleFromFile(File file) {
        String subtitleText = clovaSpeechClient.upload(file, new ClovaSpeechClient.NestRequestEntity());
        Subtitle subtitle = Subtitle.builder()
                                    .text(subtitleText)
                                    .source(file.getName())
                                    .build();
        return subtitleRepository.save(subtitle);  // 생성된 자막을 데이터베이스에 저장
    }

    // 오브젝트 스토리지 키를 통해 자막 생성
    public Subtitle generateSubtitleFromObjectStorage(String dataKey) {
        String subtitleText = clovaSpeechClient.objectStorage(dataKey, new ClovaSpeechClient.NestRequestEntity());
        Subtitle subtitle = Subtitle.builder()
                                    .text(subtitleText)
                                    .source(dataKey)
                                    .build();
        return subtitleRepository.save(subtitle);  // 생성된 자막을 데이터베이스에 저장
    }

    // ID를 통해 자막 조회
    public Subtitle getSubtitleById(Long id) {
        return subtitleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subtitle not found with id " + id));  // 자막이 없으면 예외 발생
    }
}
