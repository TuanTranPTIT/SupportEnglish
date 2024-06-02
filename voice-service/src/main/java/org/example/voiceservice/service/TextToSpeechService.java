package org.example.voiceservice.service;

import org.example.voiceservice.entity.EnglishPrompt;

import java.io.IOException;

public interface TextToSpeechService {
    EnglishPrompt textToSpeech(EnglishPrompt englishPrompt, String targetLanguage) throws IOException;
}
