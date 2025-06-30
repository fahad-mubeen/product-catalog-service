package com.project.thirdpartyserver.gateway;

import com.project.thirdpartyserver.dto.DummyJSONProductDTO;
import com.project.thirdpartyserver.dto.DummyJSONProductWrapperDTO;
import com.project.thirdpartyserver.dto.ProductDTO;
import com.project.thirdpartyserver.gateway.api.DummyJSONProductAPI;
import com.project.thirdpartyserver.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("dummyJSONProductGateway")
public class DummyJSONProductGateway_Retrofit implements IProductGateway {

    private final DummyJSONProductAPI dummyJSONProductAPI;
    public DummyJSONProductGateway_Retrofit(DummyJSONProductAPI dummyJSONProductAPI) {
        this.dummyJSONProductAPI = dummyJSONProductAPI;
    }
    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        DummyJSONProductWrapperDTO dummyJSONProductDTO = this.dummyJSONProductAPI.getAllProducts().execute().body();
        if (dummyJSONProductDTO == null) {
            throw new IOException("Failed to fetch products from DummyJSON API");
        }

        return ProductMapper.mapToProductDTOList(dummyJSONProductDTO);
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        DummyJSONProductDTO dummyJSONProductDTO = this.dummyJSONProductAPI.getProductById(id).execute().body();

        if (dummyJSONProductDTO == null) {
            throw new IOException("Failed to fetch product with ID " + id + " from DummyJSON API");
        }

        return ProductMapper.mapToProductDTO(dummyJSONProductDTO);
    }
}
