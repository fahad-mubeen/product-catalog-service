package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.dto.ProductWithCategory_DTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts() throws IOException;

    ProductDTO getProductById(Long id) throws IOException;

    ProductDTO createProduct(ProductDTO productDTO) throws IOException;

    ProductWithCategory_DTO getProductWithCategoryById(Long id) throws IOException;
}
