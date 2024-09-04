package com.jigmproject.subtitlegenerator.entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subtitles")
@Data
@NoArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class SubtitleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(name = "source")
    private String source;

    @Builder
    public SubtitleEntity(String text, String source) {
        this.text = text;
        this.source = source;
    }
}
