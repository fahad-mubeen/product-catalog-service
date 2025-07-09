package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.AllProductsOfCategoryDTO;
import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.gateway.ICategoryGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThirdPartyCategoryService implements ICategoryService {
    private final ICategoryGateway categoryGateway;
    public ThirdPartyCategoryService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() {
        return this.categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return null;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) {
        return null;
    }
}
