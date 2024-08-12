package com.Jigm_Project.SubtitleGenerator.dto;

import lombok.Data;

@Data
public class VideoRequest {
    private String videoUrl;

    // 기본 생성자
    public VideoRequest() {}

    // 매개변수가 있는 생성자
    public VideoRequest(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    // getter와 setter 메소드
    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}