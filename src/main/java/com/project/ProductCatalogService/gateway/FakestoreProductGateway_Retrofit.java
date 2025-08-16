package com.project.ProductCatalogService.gateway;

import com.project.ProductCatalogService.dto.FakestoreAllProductWrapperDTO;
import com.project.ProductCatalogService.dto.FakestoreSingleProductWrapperDTO;
import com.project.ProductCatalogService.dto.ProductDTO;
import com.project.ProductCatalogService.gateway.api.FakestoreProductAPI;
import com.project.ProductCatalogService.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component("fakestoreProductGateway")
public class FakestoreProductGateway_Retrofit implements IProductGateway {

    private final FakestoreProductAPI fakestoreProductAPI;
    public FakestoreProductGateway_Retrofit(FakestoreProductAPI fakestoreProductAPI) {
        this.fakestoreProductAPI = fakestoreProductAPI;
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        FakestoreAllProductWrapperDTO fakestoreProductWrapperDTO = this.fakestoreProductAPI.getAllProducts().execute().body();
        if (fakestoreProductWrapperDTO == null) {
            throw new IOException("Failed to fetch products from Fakestore API");
        }

        return ProductMapper.mapToProductDTOList(fakestoreProductWrapperDTO);
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        FakestoreSingleProductWrapperDTO fakestoreProductDTO = this.fakestoreProductAPI.getProductById(id).execute().body();
        if (fakestoreProductDTO == null) {
            throw new IOException("Failed to fetch product with ID " + id + " from Fakestore API");
        }
        return ProductMapper.mapToProductDTO(fakestoreProductDTO);
    }
}
