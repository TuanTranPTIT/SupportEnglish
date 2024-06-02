package org.example.textgenerationservice.service;

import org.example.textgenerationservice.entity.EnglishPrompt;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface TextGenerationService {
    EnglishPrompt generateText(EnglishPrompt englishPrompt) throws IOException;
}
