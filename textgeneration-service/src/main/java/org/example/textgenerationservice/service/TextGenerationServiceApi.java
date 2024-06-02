package org.example.textgenerationservice.service;

import org.example.textgenerationservice.model.TextGenerationRequest;
import org.example.textgenerationservice.model.TextGenerationResponse;
import retrofit2.Call;
import retrofit2.http.*;

public interface TextGenerationServiceApi {
    @POST("/v1beta/models/gemini-pro:generateContent?key=AIzaSyAa0DIQIiFx23jmQWfMf0sW5uiB8Uu0TE0")
    Call<TextGenerationResponse> generateContent(
            @Body TextGenerationRequest body
    );
}
