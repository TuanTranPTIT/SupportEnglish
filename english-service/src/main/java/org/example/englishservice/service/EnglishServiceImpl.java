package org.example.englishservice.service;

import com.google.gson.Gson;
import org.example.englishservice.entity.EnglishPrompt;
import org.example.englishservice.outservice.TextGenerationApi;
import org.example.englishservice.outservice.TranslateServiceApi;
import org.example.englishservice.outservice.VoiceSeviceApi;
import org.example.englishservice.repository.EnglishPromptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EnglishServiceImpl implements EnglishService{
    @Autowired
    private EnglishPromptRepository englishPromptRepository;

    private EnglishPrompt generateText(EnglishPrompt englishPrompt) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8762/tgs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TextGenerationApi textGenerationApi = retrofit.create(TextGenerationApi.class);
        Call<EnglishPrompt> call = textGenerationApi.generateText(englishPrompt);
        try {
            englishPrompt = call.execute().body();
            System.out.println(englishPrompt.getGeneratedText());
            return englishPrompt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private EnglishPrompt translate(EnglishPrompt englishPrompt, String language) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8762/ts/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TranslateServiceApi translateServiceApi = retrofit.create(TranslateServiceApi.class);
        Call<EnglishPrompt> call = translateServiceApi.translateText(englishPrompt, language);
        try {
            englishPrompt = call.execute().body();
            System.out.println(englishPrompt.getTranslatedText());
            return englishPrompt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private EnglishPrompt textToSpeech(EnglishPrompt englishPrompt, String targetLanguage) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8762/vs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VoiceSeviceApi textToSpeechServiceApi = retrofit.create(VoiceSeviceApi.class);
        Call<EnglishPrompt> call = textToSpeechServiceApi.textToSpeech(englishPrompt, targetLanguage);
        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public EnglishPrompt execute(EnglishPrompt englishPrompt) throws IOException {
        englishPrompt = generateText(englishPrompt);
        englishPrompt = translate(englishPrompt, "vi");
        englishPrompt = textToSpeech(englishPrompt, "en-us");
        englishPrompt = textToSpeech(englishPrompt, "vi-vn");

        assert englishPrompt != null;
        englishPrompt.setCreatedDate(String.valueOf(LocalDateTime.now()));
        englishPromptRepository.save(englishPrompt);
        return englishPrompt;
    }

    @Override
    public List<EnglishPrompt> findAll() {
        return englishPromptRepository.findAll();
    }

    @Override
    public Optional<EnglishPrompt> findById(long id) {
        return englishPromptRepository.findById(id);
    }
}
