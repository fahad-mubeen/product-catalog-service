package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.entity.Product;
import com.project.thirdpartyserver.mapper.ProductMapper;
import com.project.thirdpartyserver.repository.ProductRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("productService")
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
        return null;
    }
}
