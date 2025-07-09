package com.project.thirdpartyserver.mapper;

import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.dto.FakestoreCategoryDTO;

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
}
