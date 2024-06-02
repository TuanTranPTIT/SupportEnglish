package org.example.translateservice.controller;

import org.example.translateservice.entity.EnglishPrompt;
import org.example.translateservice.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/translate")
public class TranslateController {
    @Autowired
    private TranslateService translateService;

    // Translate text
    @PostMapping("/translate/{targetLanguage}")
    public EnglishPrompt translateText(@RequestBody EnglishPrompt englishPrompt, @PathVariable String targetLanguage) throws IOException {
        return translateService.translate(englishPrompt, targetLanguage);
    }
}
