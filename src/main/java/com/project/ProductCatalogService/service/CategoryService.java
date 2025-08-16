package com.project.ProductCatalogService.service;

import com.project.ProductCatalogService.dto.AllProductsOfCategoryDTO;
import com.project.ProductCatalogService.dto.CategoryDTO;
import com.project.ProductCatalogService.dto.ProductDTO;
import com.project.ProductCatalogService.entity.Category;
import com.project.ProductCatalogService.entity.Product;
import com.project.ProductCatalogService.exception.CategoryNotFoundException;
import com.project.ProductCatalogService.mapper.CategoryMapper;
import com.project.ProductCatalogService.mapper.ProductMapper;
import com.project.ProductCatalogService.repository.CategoryRepository;
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
                .orElseThrow(() -> new CategoryNotFoundException(id));
        return CategoryMapper.mapToCategoryDTO(category);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new IllegalArgumentException(
                    "A category with name '" + categoryDTO.getName() + "' already exists."
            );
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
