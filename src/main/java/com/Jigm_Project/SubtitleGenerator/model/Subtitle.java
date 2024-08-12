package com.Jigm_Project.SubtitleGenerator.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data; // Lombok의 어노테이션

@Entity
@Data
public class Subtitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private String language;

    // Lombok의 @Data 어노테이션이 모든 필수 메서드를 자동으로 생성합니다.
}