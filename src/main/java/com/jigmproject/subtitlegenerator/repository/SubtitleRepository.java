package com.jigmproject.subtitlegenerator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jigmproject.subtitlegenerator.model.Subtitle;

@Repository
public interface SubtitleRepository extends JpaRepository<Subtitle, Long> {
    // 필요한 추가적인 메서드를 정의
    // 예를 들어, 자막의 언어를 기준으로 자막을 검색하는 메서드를 추가
    // List<Subtitle> findByLanguage(String language);
}
