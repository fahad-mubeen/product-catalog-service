package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.CategoryDTO;
import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.dto.ProductWithCategory_DTO;
import com.project.thirdpartyserver.entity.Category;
import com.project.thirdpartyserver.entity.Product;
import com.project.thirdpartyserver.mapper.ProductMapper;
import com.project.thirdpartyserver.repository.CategoryRepository;
import com.project.thirdpartyserver.repository.ProductRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service("productService")
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        List<Product> products = productRepository.findAll();
        return ProductMapper.mapToProductDTOList(products);
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        Product product = productRepository.findById(id)
                        .orElseThrow(() -> new IOException("Product not found with ID: " + id));

        return ProductMapper.mapToProductDTO(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws IOException {
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new IOException("Category not found with ID: " + productDTO.getCategoryId()));

        Product product = ProductMapper.mapToProduct(productDTO, category);
        productRepository.save(product);
        return ProductMapper.mapToProductDTO(product);
    }

    @Override
    public ProductWithCategory_DTO getProductWithCategoryById(Long id) throws IOException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IOException("Product not found with ID: " + id));

        Category category = product.getCategory();
        CategoryDTO categoryDTO = CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();

        return ProductWithCategory_DTO.builder()
                .id(product.getId())
                .name(product.getName())
                .categoryDTO(categoryDTO)
                .build();
    }
}
