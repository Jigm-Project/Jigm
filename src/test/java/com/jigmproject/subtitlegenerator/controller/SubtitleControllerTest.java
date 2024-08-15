package com.jigmproject.subtitlegenerator.controller;

import com.jigmproject.subtitlegenerator.model.Subtitle;
import com.jigmproject.subtitlegenerator.service.SubtitleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SubtitleControllerTest {

    @Mock
    private SubtitleService subtitleService;

    @InjectMocks
    private SubtitleController subtitleController;

    @Test
    public void testGetAllSubtitles() {
        // 테스트용 자막 리스트 생성
        Subtitle subtitle1 = new Subtitle();
        subtitle1.setId(1L);
        subtitle1.setText("첫 번째 자막");

        Subtitle subtitle2 = new Subtitle();
        subtitle2.setId(2L);
        subtitle2.setText("두 번째 자막");

        List<Subtitle> subtitles = Arrays.asList(subtitle1, subtitle2);

        // subtitleService.getAllSubtitles() 메서드가 호출될 때 테스트 데이터 반환
        when(subtitleService.getAllSubtitles()).thenReturn(subtitles);

        // subtitleController.getAllSubtitles() 메서드 호출 및 결과 확인
        ResponseEntity<List<Subtitle>> response = subtitleController.getAllSubtitles();

        // 결과가 예상과 일치하는지 확인
        assertEquals(2, response.getBody().size());
        assertEquals("첫 번째 자막", response.getBody().get(0).getText());
        assertEquals("두 번째 자막", response.getBody().get(1).getText());
    }

    @Test
    public void testGetSubtitleById() {
        // 테스트용 자막 객체 생성
        Subtitle subtitle = new Subtitle();
        subtitle.setId(1L);
        subtitle.setText("테스트 자막");

        // subtitleService.getSubtitleById(1L) 메서드가 호출될 때 테스트 데이터 반환
        when(subtitleService.getSubtitleById(1L)).thenReturn(subtitle);

        // subtitleController.getSubtitleById(1L) 메서드 호출 및 결과 확인
        ResponseEntity<Subtitle> response = subtitleController.getSubtitleById(1L);

        // 결과가 예상과 일치하는지 확인
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getId());
        assertEquals("테스트 자막", response.getBody().getText());
    }

    // 추가적인 컨트롤러 테스트 메서드를 작성
}
