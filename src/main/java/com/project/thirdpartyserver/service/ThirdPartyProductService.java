package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.gateway.IProductGateway;
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
}
