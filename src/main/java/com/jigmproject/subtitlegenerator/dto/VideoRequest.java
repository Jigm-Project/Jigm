package com.jigmproject.subtitlegenerator.dto;

// 비디오 URL을 포함하는 요청 데이터를 처리하기 위한 DTO 클래스
public class VideoRequest {
    private String videoUrl;

    // 기본 생성자
    public VideoRequest() {
    }

    // 비디오 URL을 초기화하는 생성자
    public VideoRequest(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    // 비디오 URL에 접근하는 Getter 메서드
    public String getVideoUrl() {
        return videoUrl;
    }

    // 비디오 URL을 설정하는 Setter 메서드
    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
