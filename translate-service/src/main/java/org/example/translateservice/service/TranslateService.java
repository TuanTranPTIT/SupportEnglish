package org.example.translateservice.service;

import org.example.translateservice.entity.EnglishPrompt;

import java.io.IOException;

public interface TranslateService {
    EnglishPrompt translate(EnglishPrompt englishPrompt, String targetLanguage) throws IOException;
}
