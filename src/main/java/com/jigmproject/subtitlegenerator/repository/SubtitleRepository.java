package com.jigmproject.subtitlegenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jigmproject.subtitlegenerator.entity.SubtitleEntity;

@Repository  // 스프링에서 리포지토리로 인식하도록 명시
public interface SubtitleRepository extends JpaRepository<SubtitleEntity, Long> {
    // JpaRepository를 상속받아 기본적인 CRUD 메서드 제공
}
