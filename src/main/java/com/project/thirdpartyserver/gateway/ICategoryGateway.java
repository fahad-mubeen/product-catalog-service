package com.project.thirdpartyserver.gateway;

import com.project.thirdpartyserver.dto.CategoryDTO;

import java.util.List;

public interface ICategoryGateway {
    public List<CategoryDTO> getAllCategories();
}
