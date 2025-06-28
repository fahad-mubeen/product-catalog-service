package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.gateway.ICategoryGateway;
import com.project.thirdpartyserver.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final ICategoryGateway categoryGateway;
    public CategoryService(ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }
    @Override
    public List<CategoryDTO> getAllCategories() {
        return this.categoryGateway.getAllCategories();
    }
}
