package org.example.englishservice.outservice;

import org.example.englishservice.entity.EnglishPrompt;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface VoiceSeviceApi {
    @POST("voice/textToSpeech/{targetLanguage}")
    Call<EnglishPrompt> textToSpeech(
            @Body EnglishPrompt englishPrompt,
            @Path("targetLanguage") String targetLanguage
    );
}
