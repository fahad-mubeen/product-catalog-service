package com.project.thirdpartyserver.gateway;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.dto.FakestoreCategoryDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakestoreCategoryGateway_OKHTTP implements ICategoryGateway {

    private final OkHttpClient client;
    private final String fakestoreApiBaseUrl;

    public FakestoreCategoryGateway_OKHTTP(OkHttpClient client, @Value("${api.fakestore.base-url}") String baseUrl) {
        this.client = client;
        this.fakestoreApiBaseUrl = baseUrl;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        String url = fakestoreApiBaseUrl + "products/category";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new RuntimeException("Failed to fetch categories: " + response.message());
            }

            String jsonString = response.body().string();
            Gson gson = new Gson();
            FakestoreCategoryDTO fakestoreCategoryDTO = gson.fromJson(jsonString, FakestoreCategoryDTO.class);

            List<CategoryDTO> dtoList = new ArrayList<>();
            for (String name : fakestoreCategoryDTO.getCategories()) {
                dtoList.add(new CategoryDTO(name));
            }
            return dtoList;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching categories", e);
        }
    }
}
