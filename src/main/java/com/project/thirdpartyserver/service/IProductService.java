package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    List<ProductDTO> getAllProducts() throws IOException;

    ProductDTO getProductById(Long id) throws IOException;
}
