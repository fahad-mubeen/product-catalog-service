package com.project.ProductCatalogService.service;

import com.project.ProductCatalogService.dto.ProductDTO;
import com.project.ProductCatalogService.dto.ProductWithCategory_DTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts() throws IOException;

    ProductDTO getProductById(Long id) throws IOException;

    ProductDTO createProduct(ProductDTO productDTO) throws IOException;

    ProductWithCategory_DTO getProductWithCategoryById(Long id) throws IOException;

    List<ProductDTO> getProductsLessThanEqualPrice(double price);

    Integer countProductsLessThanEqualPrice(double price);

    Integer countProductsBetweenPrice(double low, double high);
}
