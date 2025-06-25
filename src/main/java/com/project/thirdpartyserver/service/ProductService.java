package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        return List.of();
    }
}
