package com.jigmproject.subtitlegenerator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jigmproject.subtitlegenerator.model.Subtitle;
import com.jigmproject.subtitlegenerator.repository.SubtitleRepository;

@Service
public class SubtitleService {

    private final SubtitleRepository subtitleRepository;

    public SubtitleService(SubtitleRepository subtitleRepository) {
        this.subtitleRepository = subtitleRepository;
    }

    public String generateSubtitle(String videoUrl) {
        Subtitle subtitle = new Subtitle();
        subtitle.setText("영상 자막 생성: " + videoUrl);
        subtitle.setLanguage("ko");
        subtitleRepository.save(subtitle);
        return subtitle.getText();
    }

    public List<Subtitle> getAllSubtitles() {
        return subtitleRepository.findAll();
    }

    public Subtitle getSubtitleById(Long id) {
        return subtitleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("자막을 생성할 수 없습니다."));
    }

    public Subtitle updateSubtitle(Long id, Subtitle subtitleDetails) {
        Subtitle subtitle = getSubtitleById(id);
        subtitle.setText(subtitleDetails.getText());
        subtitle.setLanguage(subtitleDetails.getLanguage());
        return subtitleRepository.save(subtitle);
    }

    public void deleteSubtitle(Long id) {
        Subtitle subtitle = getSubtitleById(id);
        subtitleRepository.delete(subtitle);
    }
}
