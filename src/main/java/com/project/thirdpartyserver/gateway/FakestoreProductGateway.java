package com.project.thirdpartyserver.gateway;

import com.project.thirdpartyserver.dto.FakestoreProductDTO;
import com.project.thirdpartyserver.dto.FakestoreProductWrapperDTO;
import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.gateway.api.FakestoreProductAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("fakestoreProductGateway")
public class FakestoreProductGateway implements IProductGateway {

    private final FakestoreProductAPI fakestoreProductAPI;
    public FakestoreProductGateway(FakestoreProductAPI fakestoreProductAPI) {
        this.fakestoreProductAPI = fakestoreProductAPI;
    }

    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        FakestoreProductWrapperDTO fakestoreProductWrapperDTO = this.fakestoreProductAPI.getAllProducts().execute().body();
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
}
