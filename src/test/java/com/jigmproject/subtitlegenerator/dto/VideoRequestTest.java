package com.jigmproject.subtitlegenerator.dto;

import lombok.Data;

@Data
public class VideoRequestTest {
    private String videoUrl;

    // 기본 생성자
    public VideoRequestTest() {}

    // 매개변수가 있는 생성자
    public VideoRequestTest(String videoUrl) {
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