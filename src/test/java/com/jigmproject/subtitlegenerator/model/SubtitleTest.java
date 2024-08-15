package com.jigmproject.subtitlegenerator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class SubtitleTest {

    @Test
    public void testSubtitleGettersAndSetters() {
        // 자막 객체를 생성하고 값을 설정
        Subtitle subtitle = new Subtitle();
        subtitle.setId(1L);
        subtitle.setText("테스트 자막");
        subtitle.setLanguage("ko");

        // 설정된 값이 올바르게 반환되는지 확인
        assertEquals(1L, subtitle.getId());
        assertEquals("테스트 자막", subtitle.getText());
        assertEquals("ko", subtitle.getLanguage());
    }
}
