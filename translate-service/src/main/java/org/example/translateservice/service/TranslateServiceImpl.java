package org.example.translateservice.service;

import org.example.translateservice.entity.EnglishPrompt;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;

@Service
public class TranslateServiceImpl implements TranslateService {
    @Override
    public EnglishPrompt translate(EnglishPrompt englishPrompt, String targetLanguage) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://clients5.google.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();

        TranslateServiceApi service = retrofit.create(TranslateServiceApi.class);

        Call<String> call = service.translateText(
                "gtx",
                "auto", targetLanguage,
                "t",
                englishPrompt.getGeneratedText()
        );

        Response<String> response = call.execute();


        if (response.isSuccessful()) {
            try {
                JSONArray jsonArray = new JSONArray(response.body()); // Convert response body to JSON array
                if (jsonArray.length() > 0) {
                    JSONArray translationArray = jsonArray.optJSONArray(0); // Get the first array from the JSON array
                    if (translationArray != null && translationArray.length() > 0) {
                        String translatedText = translationArray.optString(0); // Get the first element from the translation array
                        englishPrompt.setTranslatedText(translatedText);
                    } else {
                        System.out.println("No translation found");
                    }
                } else {
                    System.out.println("No translation found");
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return englishPrompt;
    }
}
