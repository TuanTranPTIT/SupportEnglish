package org.example.textgenerationservice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
    private String createdDate;
}
