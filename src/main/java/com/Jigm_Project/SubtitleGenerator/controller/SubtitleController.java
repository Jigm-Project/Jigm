package com.Jigm_Project.SubtitleGenerator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.Jigm_Project.SubtitleGenerator.dto.VideoRequest;
import com.Jigm_Project.SubtitleGenerator.model.Subtitle;
import com.Jigm_Project.SubtitleGenerator.service.SubtitleService;

import java.util.List;

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