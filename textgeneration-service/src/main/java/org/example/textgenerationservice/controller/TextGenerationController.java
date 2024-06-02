package org.example.textgenerationservice.controller;

import org.example.textgenerationservice.entity.EnglishPrompt;
import org.example.textgenerationservice.service.TextGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/text-generation")
public class TextGenerationController {
    @Autowired
    private TextGenerationService textGenerationService;

    // Generate text
    @PostMapping("/generate")
    public EnglishPrompt generateText(@RequestBody EnglishPrompt englishPrompt) throws IOException {
        return textGenerationService.generateText(englishPrompt);
    }

}
