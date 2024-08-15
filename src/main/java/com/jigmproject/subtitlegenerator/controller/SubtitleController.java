package com.jigmproject.subtitlegenerator.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jigmproject.subtitlegenerator.dto.VideoRequest;
import com.jigmproject.subtitlegenerator.model.Subtitle;
import com.jigmproject.subtitlegenerator.service.SubtitleService;

@RestController
@RequestMapping("/api/v1/subtitles")
public class SubtitleController {

    private final SubtitleService subtitleService;

    public SubtitleController(SubtitleService subtitleService) {
        this.subtitleService = subtitleService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateSubtitle(@RequestBody VideoRequest videoRequest) {
        String subtitle = subtitleService.generateSubtitle(videoRequest.getVideoUrl());
        return ResponseEntity.ok(subtitle);
    }

    @GetMapping
    public ResponseEntity<List<Subtitle>> getAllSubtitles() {
        List<Subtitle> subtitles = subtitleService.getAllSubtitles();
        return ResponseEntity.ok(subtitles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subtitle> getSubtitleById(@PathVariable Long id) {
        Subtitle subtitle = subtitleService.getSubtitleById(id);
        return ResponseEntity.ok(subtitle);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subtitle> updateSubtitle(@PathVariable Long id, @RequestBody Subtitle subtitleDetails) {
        Subtitle updatedSubtitle = subtitleService.updateSubtitle(id, subtitleDetails);
        return ResponseEntity.ok(updatedSubtitle);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubtitle(@PathVariable Long id) {
        subtitleService.deleteSubtitle(id);
        return ResponseEntity.noContent().build();
    }
}
