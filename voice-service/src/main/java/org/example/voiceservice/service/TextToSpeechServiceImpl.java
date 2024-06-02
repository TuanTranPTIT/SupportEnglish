package org.example.voiceservice.service;


import org.example.voiceservice.entity.EnglishPrompt;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;


@Service
public class TextToSpeechServiceImpl implements TextToSpeechService{


    @Override
    public EnglishPrompt textToSpeech(EnglishPrompt englishPrompt, String targetLanguage) throws IOException {
        String text = null;

        if (targetLanguage.equals("en-us")){
            text = englishPrompt.getGeneratedText();
        }
        if (targetLanguage.equals("vi-vn")){
            text = englishPrompt.getTranslatedText();
        }

        String API_URL = "https://voicerss-text-to-speech.p.rapidapi.com";
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "c531e23983msh5561e6d564d22ddp149d44jsn2c2cf60224c6");
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("key", "96f7627a9a16464fb5318909083ae7f0");
        map.add("src", text);
        map.add("hl", targetLanguage);
        map.add("r", "0");
        map.add("c", "mp3");
        map.add("f", "8khz_8bit_mono");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<byte[]> response = restTemplate.postForEntity(API_URL, request, byte[].class);
        createAudioFromByteArray(response.getBody(), englishPrompt, targetLanguage);
        return englishPrompt;
    }

    private void createAudioFromByteArray(byte[] audioData, EnglishPrompt englishPrompt, String targetLanguage) throws IOException {
        Resource resource = new ClassPathResource("static/audio");
        Path filePath = Paths.get(resource.getFile().getPath(), randomFile() + "_" + targetLanguage + ".mp3");

        try (OutputStream outputStream = Files.newOutputStream(filePath)) {
            FileCopyUtils.copy(audioData, outputStream);
            if (targetLanguage.equals("en-us")){
                englishPrompt.setEnglishVoice(String.valueOf(filePath));
            }
            if (targetLanguage.equals("vi-vn")){
                englishPrompt.setVietnameseVoice(String.valueOf(filePath));
            }
            System.out.println("Path: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error creating audio file: " + e.getMessage());
        }
    }
    public String randomFile() {
        int length = 30;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
