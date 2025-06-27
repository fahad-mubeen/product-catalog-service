package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Override
    public List<CategoryDTO> getAllCategories() {
        return List.of();
    }
}
