package com.jigmproject.subtitlegenerator.repository;

import com.jigmproject.subtitlegenerator.model.Subtitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class SubtitleRepositoryTest {

    @Autowired
    private SubtitleRepository subtitleRepository;

    @Test
    public void testSaveSubtitle() {
        // 새로운 자막 엔티티를 생성하여 저장
        Subtitle subtitle = new Subtitle();
        subtitle.setText("저장된 자막");
        subtitle.setLanguage("ko");

        Subtitle savedSubtitle = subtitleRepository.save(subtitle);

        // 저장된 자막이 데이터베이스에 존재하는지 확인
        Optional<Subtitle> result = subtitleRepository.findById(savedSubtitle.getId());

        assertTrue(result.isPresent());
        assertEquals("저장된 자막", result.get().getText());
    }

    // 추가적인 리포지토리 테스트 메서드를 작성할 수 있습니다.
}
