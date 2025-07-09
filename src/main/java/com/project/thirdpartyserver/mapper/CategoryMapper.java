package com.project.thirdpartyserver.mapper;

import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.dto.FakestoreCategoryDTO;
import com.project.thirdpartyserver.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static List<CategoryDTO> mapToCategoryDTOList(FakestoreCategoryDTO fakestoreCategoryDTO) {
        List<CategoryDTO> dtoList = new ArrayList<>();
        for (String name : fakestoreCategoryDTO.getCategories()) {
            dtoList.add(new CategoryDTO(-1L, name));
        }
        return dtoList;
    }

    public static List<CategoryDTO> mapToCategoryDTOList(List<Category> categories) {
        List<CategoryDTO> dtoList = new ArrayList<>();
        for (Category category : categories) {
            dtoList.add(mapToCategoryDTO(category));
        }
        return dtoList;
    }

    public static CategoryDTO mapToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category mapToCategory(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }
}
