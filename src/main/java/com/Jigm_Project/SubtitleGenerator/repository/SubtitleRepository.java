package com.Jigm_Project.SubtitleGenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Jigm_Project.SubtitleGenerator.model.Subtitle;

public interface SubtitleRepository extends JpaRepository<Subtitle, Long> {
    // 자막 관련 DB 작업 메서드 추가 가능
}