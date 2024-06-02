package org.example.voiceservice.controller;

import org.example.voiceservice.entity.EnglishPrompt;
import org.example.voiceservice.service.TextToSpeechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/voice")
public class VoiceServiceController {
    @Autowired
    private TextToSpeechService textToSpeechService;

    // Text to speech
    @PostMapping("/textToSpeech/{targetLanguage}")
    public EnglishPrompt textToSpeech(@RequestBody EnglishPrompt englishPrompt, @PathVariable String targetLanguage) throws IOException {
        return textToSpeechService.textToSpeech(englishPrompt, targetLanguage);
    }
}
