package com.project.ProductCatalogService.gateway;

import com.project.ProductCatalogService.dto.CategoryDTO;

import java.util.List;

public interface ICategoryGateway {
    public List<CategoryDTO> getAllCategories();
}
