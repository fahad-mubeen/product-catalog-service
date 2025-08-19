package com.project.ProductCatalogService.service;

import com.project.ProductCatalogService.dto.CategoryDTO;
import com.project.ProductCatalogService.dto.ProductDTO;
import com.project.ProductCatalogService.dto.ProductWithCategory_DTO;
import com.project.ProductCatalogService.entity.Category;
import com.project.ProductCatalogService.entity.Product;
import com.project.ProductCatalogService.mapper.ProductMapper;
import com.project.ProductCatalogService.repository.CategoryRepository;
import com.project.ProductCatalogService.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

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

    @Override
    public List<ProductDTO> getProductsLessThanEqualPrice(double price) {
        if(price < 0){
            return List.of();
        }
        List<Product> products = productRepository.getProductsLessThanEqualPrice(price);
        return ProductMapper.mapToProductDTOList(products);
    }

    @Override
    public Integer countProductsLessThanEqualPrice(double price) {
        if(price < 0){
            return 0;
        }
        return productRepository.countProductsLessThanEqualPrice(price);
    }

    @Override
    public Integer countProductsBetweenPrice(double low, double high) {
        return productRepository.countProductsBetweenPrice(low, high);
    }
}
