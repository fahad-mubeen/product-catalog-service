package com.project.thirdpartyserver.gateway;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.project.thirdpartyserver.dto.CategoryDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Component
public class FakestoreCategoryGateway_OKHTTP implements ICategoryGateway {

    OkHttpClient client = new OkHttpClient();

    @Value("${api.fakestore.base-url}")
    private String fakestoreApiBaseUrl;

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
            String responseBody = response.body().string();

            List<CategoryDTO> categoryDTOList = new ArrayList<>();
            categoryDTOList.add(CategoryDTO.builder().name("All").build());
//            Type categoryListType = new TypeToken<List<String>>(){}.getType();
//            Gson gson = new Gson();
//            List<String> categories = gson.fromJson(responseBody, categoryListType);
//
//            for (String category : categories) {
//                CategoryDTO categoryDTO = CategoryDTO.builder()
//                        .name(category)
//                        .build();
//                categoryDTOList.add(categoryDTO);
//            }

            return categoryDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching categories", e);
        }
    }
}
