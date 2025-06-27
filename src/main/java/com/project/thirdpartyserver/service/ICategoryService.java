package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    List<CategoryDTO> getAllCategories();
}
