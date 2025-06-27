package com.project.thirdpartyserver.gateway;

import com.project.thirdpartyserver.dto.CategoryDTO;

import java.util.List;

public class FakestoreCategoryGateway_OKHTTP implements ICategoryGateway {
    @Override
    public List<CategoryDTO> getAllCategories() {
        return List.of();
    }
}
