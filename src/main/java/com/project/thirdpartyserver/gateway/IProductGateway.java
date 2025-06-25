package com.project.thirdpartyserver.gateway;

import com.project.thirdpartyserver.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {
    List<ProductDTO> getAllProducts() throws IOException;
}
