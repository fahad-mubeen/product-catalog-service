package com.project.ProductCatalogService.gateway;

import com.project.ProductCatalogService.dto.CategoryDTO;
import com.project.ProductCatalogService.dto.FakestoreCategoryDTO;
import com.project.ProductCatalogService.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Primary
@Component
public class FakestoreCategoryGateway_RestTemplate implements ICategoryGateway {

    private RestTemplate restTemplate = new RestTemplate();
    private final String fakestoreApiBaseUrl;
    FakestoreCategoryGateway_RestTemplate(@Value("${api.fakestore.base-url}") String fakestoreApiBaseUrl) {
        this.fakestoreApiBaseUrl = fakestoreApiBaseUrl;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        String url = fakestoreApiBaseUrl + "products/category";
        FakestoreCategoryDTO fakestoreCategoryDTO = restTemplate.getForObject(url, FakestoreCategoryDTO.class);
        if (fakestoreCategoryDTO == null || fakestoreCategoryDTO.getCategories() == null) {
            throw new RuntimeException("Failed to fetch categories or categories are empty");
        }

        return CategoryMapper.mapToCategoryDTOList(fakestoreCategoryDTO);
    }
}
