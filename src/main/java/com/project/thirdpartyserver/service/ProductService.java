package com.project.thirdpartyserver.service;

import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.gateway.IProductGateway;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductGateway productGateway;
    public ProductService(@Qualifier("dummyJSONProductGateway") IProductGateway productGateway) {
        this.productGateway = productGateway;
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        return this.productGateway.getAllProducts();
    }
}
