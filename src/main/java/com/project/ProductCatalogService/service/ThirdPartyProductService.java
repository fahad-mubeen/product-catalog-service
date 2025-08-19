package com.project.ProductCatalogService.service;

import com.project.ProductCatalogService.dto.ProductDTO;
import com.project.ProductCatalogService.dto.ProductWithCategory_DTO;
import com.project.ProductCatalogService.gateway.IProductGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("thirdPartyProductService")
public class ThirdPartyProductService implements IProductService {

    private final IProductGateway productGateway;
    public ThirdPartyProductService(@Qualifier("fakestoreProductGateway") IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        return this.productGateway.getAllProducts();
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        return this.productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws IOException {
        return null;
    }

    @Override
    public ProductWithCategory_DTO getProductWithCategoryById(Long id) throws IOException {
        return null;
    }

    @Override
    public List<ProductDTO> getProductsLessThanEqualPrice(double price) {
        return List.of();
    }

    @Override
    public Integer countProductsLessThanEqualPrice(double price) {
        return 0;
    }

    @Override
    public Integer countProductsBetweenPrice(double low, double high) {
        return 0;
    }
}
