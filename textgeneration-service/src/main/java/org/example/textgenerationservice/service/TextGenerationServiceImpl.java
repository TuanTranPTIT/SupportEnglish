package org.example.textgenerationservice.service;

import com.google.gson.Gson;
import org.example.textgenerationservice.entity.EnglishPrompt;
import org.example.textgenerationservice.model.TextGenerationRequest;
import org.example.textgenerationservice.model.TextGenerationResponse;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Collections;

@Service
public class TextGenerationServiceImpl implements TextGenerationService {
    public EnglishPrompt generateText(EnglishPrompt englishPrompt) throws IOException {
        // Make a request
        TextGenerationRequest request = new TextGenerationRequest(Collections.singletonList(
                new TextGenerationRequest.Content(Collections.singletonList(
                        new TextGenerationRequest.Part(englishPrompt.getPrompt())
                ))
        ));
        // Initialize Gson
        Gson gson = new Gson();

        // Convert Java object to JSON string
        String jsonString = gson.toJson(request);

        // Print JSON string
        System.out.println(jsonString);
        // Create Retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://generativelanguage.googleapis.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create service instance
        TextGenerationServiceApi service = retrofit.create(TextGenerationServiceApi.class);

        // Make API call
        Call<TextGenerationResponse> call = service.generateContent(
                request
        );

        // Execute the call and get the response
        Response<TextGenerationResponse> response = call.execute();

        // Check if the response is successful
        if (response.isSuccessful()) {
            // Get the response body
            TextGenerationResponse responseBody = response.body();
            assert responseBody != null;
            System.out.println(responseBody.getCandidates().get(0).getContent().getParts().get(0).getText());
            englishPrompt.setGeneratedText(responseBody.getCandidates().get(0).getContent().getParts().get(0).getText());
        } else {
            assert response.errorBody() != null;
            System.out.println(response.errorBody().string());
        }
        System.out.println(englishPrompt.getGeneratedText());
        return englishPrompt;
    }
}
