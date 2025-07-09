package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.AllProductsOfCategoryDTO;
import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.entity.Category;
import com.project.thirdpartyserver.entity.Product;
import com.project.thirdpartyserver.mapper.CategoryMapper;
import com.project.thirdpartyserver.mapper.ProductMapper;
import com.project.thirdpartyserver.repository.CategoryRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("categoryService")
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        return CategoryMapper.mapToCategoryDTOList(categoryList);
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + id));
        return CategoryMapper.mapToCategoryDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.existsById(categoryDTO.getId())) {
            throw new RuntimeException("Category with ID " + categoryDTO.getId() + " already exists.");
        }
        Category category = CategoryMapper.mapToCategory(categoryDTO);
        categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDTO(category);
    }

    @Override
    public AllProductsOfCategoryDTO getAllProductsOfCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + categoryId));

        List<Product> products = category.getProducts();
        List<ProductDTO> productDTOList = ProductMapper.mapToProductDTOList(products);

        return AllProductsOfCategoryDTO.builder()
                .name(category.getName())
                .categoryId(category.getId())
                .products(productDTOList)
                .build();
    }
}
