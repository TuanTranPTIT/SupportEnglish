package org.example.translateservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EnglishPrompt {
    private Long id;
    private String prompt;
    private String generatedText;
    private String translatedText;
    private String englishVoice;
    private String vietnameseVoice;
    private LocalDateTime createdDate;
}
