package org.example.englishservice.repository;

import org.example.englishservice.entity.EnglishPrompt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnglishPromptRepository extends JpaRepository<EnglishPrompt, Long>{
}
