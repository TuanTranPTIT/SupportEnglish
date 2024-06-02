package org.example.englishservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "english")
public class EnglishPrompt {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Prompt")
    private String prompt;
    @Column(name = "GeneratedText")
    private String generatedText;
    @Column(name = "TranslatedText")
    private String translatedText;
    @Column(name = "EnglishVoice")
    private String englishVoice;
    @Column(name = "VietnameseVoice")
    private String vietnameseVoice;
    @Column(name = "CreatedDate")
    private String createdDate;
}
