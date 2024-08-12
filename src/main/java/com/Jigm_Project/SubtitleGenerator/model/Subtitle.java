package com.Jigm_Project.SubtitleGenerator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data; // Lombok의 어노테이션

@Entity
@Table(name = "subtitles") // 테이블 이름을 명시적으로 설정
@Data
public class Subtitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String language;

    // Lombok의 @Data 어노테이션이 모든 필수 메서드를 자동으로 생성합니다.
}