package com.jigmproject.subtitlegenerator.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jigmproject.clovaspeech.ClovaSpeechClient;
import com.jigmproject.subtitlegenerator.entity.SubtitleEntity;

@Service
public class SubtitleService {

    @Value("${clova.secret.key}")
    private String clovaSecretKey;

    @Value("${clova.invoke.url}")
    private String clovaInvokeUrl;

    // ClovaSpeechClient 생성 및 설정 로직을 하나의 메서드로 통합
    private ClovaSpeechClient createClovaSpeechClient() {
        return new ClovaSpeechClient(clovaSecretKey, clovaInvokeUrl);
    }

    // 파일을 통해 자막 생성
    public SubtitleEntity generateSubtitleFromFile(MultipartFile file) throws IOException {
        // 임시 파일로 저장
        Path tempFilePath = Files.createTempFile("upload-", ".mp4");
        file.transferTo(tempFilePath.toFile());

        // ClovaSpeechClient 사용하여 음성 인식 요청
        ClovaSpeechClient clovaSpeechClient = createClovaSpeechClient();
        ClovaSpeechClient.NestRequestEntity nestRequestEntity = new ClovaSpeechClient.NestRequestEntity();
        nestRequestEntity.setLanguage("ko-KR");
        nestRequestEntity.setCompletion("sync");

        // 음성 인식 요청 및 응답 처리
        String responseJson = clovaSpeechClient.upload(tempFilePath.toFile(), nestRequestEntity);

        // JSON 응답 파싱 및 자막 생성
        SubtitleEntity subtitle = new SubtitleEntity();
        subtitle.setText(responseJson); // 실제로는 JSON을 파싱하여 자막 텍스트를 설정합니다.

        // 임시 파일 삭제
        Files.deleteIfExists(tempFilePath);

        return subtitle;
    }

    // URL을 통해 자막 생성
    public SubtitleEntity generateSubtitleFromUrl(String videoUrl) {
        // ClovaSpeechClient 사용하여 URL에서 자막 생성
        ClovaSpeechClient clovaSpeechClient = createClovaSpeechClient();
        ClovaSpeechClient.NestRequestEntity nestRequestEntity = new ClovaSpeechClient.NestRequestEntity();
        nestRequestEntity.setLanguage("ko-KR");
        nestRequestEntity.setCompletion("sync");

        // URL을 사용하여 음성 인식 요청
        String responseJson = clovaSpeechClient.url(videoUrl, nestRequestEntity);

        // JSON 응답 파싱 및 자막 생성
        SubtitleEntity subtitle = new SubtitleEntity();
        subtitle.setText(responseJson); // 실제로는 JSON을 파싱하여 자막 텍스트를 설정합니다.

        return subtitle;
    }
}
