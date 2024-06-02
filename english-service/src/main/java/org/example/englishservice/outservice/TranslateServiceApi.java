package org.example.englishservice.outservice;

import org.example.englishservice.entity.EnglishPrompt;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TranslateServiceApi {
    @POST("translate/translate/{targetLanguage}")
    Call<EnglishPrompt> translateText(
            @Body EnglishPrompt englishPrompt,
            @Path("targetLanguage") String targetLanguage
    );
}
