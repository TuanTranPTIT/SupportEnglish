package org.example.englishservice.controller;

import org.example.englishservice.entity.EnglishPrompt;
import org.example.englishservice.service.EnglishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/english")
public class EnglishController {
    @Autowired
    private EnglishService englishService;

    // Execute
    @PostMapping("/execute")
    public EnglishPrompt execute(@RequestBody EnglishPrompt englishPrompt) throws IOException {
        System.out.println("EnglishController: execute" + englishPrompt.getPrompt());
        return englishService.execute(englishPrompt);
    }
    @GetMapping("/getAll")
    public List<EnglishPrompt> findAll(){
        return englishService.findAll();
    }
    @GetMapping("/getform")
    public EnglishPrompt findById(@RequestParam(name = "id") long id){
        return (EnglishPrompt) englishService.findById(id).orElse(null);
    }
}
