package com.project.thirdpartyserver.gateway;

import com.project.thirdpartyserver.dto.DummyJSONProductDTO;
import com.project.thirdpartyserver.dto.DummyJSONProductWrapperDTO;
import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.gateway.api.DummyJSONProductAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("dummyJSONProductGateway")
public class DummyJSONProductGateway implements IProductGateway {

    private final DummyJSONProductAPI dummyJSONProductAPI;
    public DummyJSONProductGateway(DummyJSONProductAPI dummyJSONProductAPI) {
        this.dummyJSONProductAPI = dummyJSONProductAPI;
    }
    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        DummyJSONProductWrapperDTO dummyJSONProductDTO = this.dummyJSONProductAPI.getAllProducts().execute().body();

        if (dummyJSONProductDTO == null) {
            throw new IOException("Failed to fetch products from DummyJSON API");
        }

        List<DummyJSONProductDTO> dummyJSONProductList = dummyJSONProductDTO.getProducts();

        if (dummyJSONProductList == null) {
            throw new IOException("Products list is null in API response");
        }

        List<ProductDTO> productDTOList = new ArrayList<>();
        for (DummyJSONProductDTO dummyJSONProduct : dummyJSONProductList) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(dummyJSONProduct.getId())
                    .name(dummyJSONProduct.getTitle())
                    .build();
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }
}
