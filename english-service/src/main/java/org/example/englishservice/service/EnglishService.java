package org.example.englishservice.service;

import org.example.englishservice.entity.EnglishPrompt;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public interface EnglishService {
    EnglishPrompt execute(EnglishPrompt englishPrompt) throws IOException;
    List<EnglishPrompt> findAll();
    Optional<EnglishPrompt> findById(long id);
}
