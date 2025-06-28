package com.project.thirdpartyserver.gateway;

import com.project.thirdpartyserver.dto.FakestoreProductDTO;
import com.project.thirdpartyserver.dto.FakestoreAllProductWrapperDTO;
import com.project.thirdpartyserver.dto.FakestoreSingleProductWrapperDTO;
import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.gateway.api.FakestoreProductAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
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

        List<FakestoreProductDTO> fakestoreProductList = fakestoreProductWrapperDTO.getProducts();
        if (fakestoreProductList == null) {
            throw new IOException("Products list is null in API response");
        }

        List<ProductDTO> productDTOList = new ArrayList<>();
        for (FakestoreProductDTO fakestoreProduct : fakestoreProductList) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id((long) fakestoreProduct.getId())
                    .name(fakestoreProduct.getTitle())
                    .build();
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        FakestoreSingleProductWrapperDTO fakestoreProductDTO = this.fakestoreProductAPI.getProductById(id).execute().body();
        if (fakestoreProductDTO == null) {
            throw new IOException("Failed to fetch product with ID " + id + " from Fakestore API");
        }
        FakestoreProductDTO product = fakestoreProductDTO.getProduct();
        if (product == null) {
            throw new IOException("Product with ID " + id + " not found in API response");
        }
        return ProductDTO.builder()
                .id((long) product.getId())
                .name(product.getTitle())
                .build();
    }
}
