package com.jigmproject.subtitlegenerator.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.context.SpringBootTest;

import com.jigmproject.subtitlegenerator.model.Subtitle;
import com.jigmproject.subtitlegenerator.repository.SubtitleRepository;

@SpringBootTest
public class SubtitleServiceTest {

    @Mock
    private SubtitleRepository subtitleRepository;

    @InjectMocks
    private SubtitleService subtitleService;

    @Test
    public void testGenerateSubtitle() {
        String videoUrl = "http://example.com/video";
        Subtitle subtitle = new Subtitle();
        subtitle.setText("영상 자막 생성: " + videoUrl);
        subtitle.setLanguage("ko");

        when(subtitleRepository.save(any(Subtitle.class))).thenReturn(subtitle);

        String generatedText = subtitleService.generateSubtitle(videoUrl);

        assertEquals(subtitle.getText(), generatedText);
        verify(subtitleRepository, times(1)).save(any(Subtitle.class));
    }

    @Test
    public void testGetAllSubtitles() {
        Subtitle subtitle1 = new Subtitle();
        subtitle1.setId(1L);
        subtitle1.setText("첫 번째 자막");

        Subtitle subtitle2 = new Subtitle();
        subtitle2.setId(2L);
        subtitle2.setText("두 번째 자막");

        List<Subtitle> subtitles = Arrays.asList(subtitle1, subtitle2);

        when(subtitleRepository.findAll()).thenReturn(subtitles);

        List<Subtitle> result = subtitleService.getAllSubtitles();

        assertEquals(2, result.size());
        verify(subtitleRepository, times(1)).findAll();
    }

    @Test
    public void testGetSubtitleById() {
        Subtitle subtitle = new Subtitle();
        subtitle.setId(1L);
        subtitle.setText("테스트 자막");

        when(subtitleRepository.findById(1L)).thenReturn(Optional.of(subtitle));

        Subtitle result = subtitleService.getSubtitleById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("테스트 자막", result.getText());
        verify(subtitleRepository, times(1)).findById(1L);
    }

    @Test
    public void testUpdateSubtitle() {
        Subtitle subtitle = new Subtitle();
        subtitle.setId(1L);
        subtitle.setText("원래 자막");

        Subtitle updatedSubtitle = new Subtitle();
        updatedSubtitle.setText("업데이트된 자막");

        when(subtitleRepository.findById(1L)).thenReturn(Optional.of(subtitle));
        when(subtitleRepository.save(subtitle)).thenReturn(updatedSubtitle);

        Subtitle result = subtitleService.updateSubtitle(1L, updatedSubtitle);

        assertNotNull(result);
        assertEquals("업데이트된 자막", result.getText());
        verify(subtitleRepository, times(1)).findById(1L);
        verify(subtitleRepository, times(1)).save(subtitle);
    }

    @Test
    public void testDeleteSubtitle() {
        Subtitle subtitle = new Subtitle();
        subtitle.setId(1L);
        subtitle.setText("테스트 자막");

        when(subtitleRepository.findById(1L)).thenReturn(Optional.of(subtitle));
        doNothing().when(subtitleRepository).delete(subtitle);

        subtitleService.deleteSubtitle(1L);

        verify(subtitleRepository, times(1)).findById(1L);
        verify(subtitleRepository, times(1)).delete(subtitle);
    }
}
