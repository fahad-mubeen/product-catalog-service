package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.entity.Category;
import com.project.thirdpartyserver.mapper.CategoryMapper;
import com.project.thirdpartyserver.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategorySeviceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() {
        // Arrange
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().id(1L).name("Category 1").build();
        Category category2 = Category.builder().id(2L).name("Category 2").build();
        categories.add(category1);
        categories.add(category2);
        when(categoryRepository.findAll()).thenReturn(categories);

        // Act
        List<CategoryDTO> categoryDTOs = categoryService.getAllCategories();

        // Assert
        assertEquals(2, categoryDTOs.size());
        verify(this.categoryRepository, times(1)).findAll();
    }
}
