package org.example.englishservice.outservice;

import org.example.englishservice.entity.EnglishPrompt;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface TextGenerationApi {
    @POST("text-generation/generate")
    Call<EnglishPrompt> generateText(
            @Body EnglishPrompt englishPrompt
    );
}
