package com.project.thirdpartyserver.mapper;

import com.project.thirdpartyserver.dto.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static List<ProductDTO> mapToProductDTOList(FakestoreAllProductWrapperDTO fakestoreProductWrapperDTO) throws IOException {
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

    public static List<ProductDTO> mapToProductDTOList(DummyJSONProductWrapperDTO dummyJSONProductDTO) throws IOException {
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

    public static ProductDTO mapToProductDTO(FakestoreSingleProductWrapperDTO fakestoreProductDTO) throws IOException {
        FakestoreProductDTO product = fakestoreProductDTO.getProduct();
        if (product == null) {
            throw new IOException("Product is null in API response");
        }

        return ProductDTO.builder()
                .id((long) product.getId())
                .name(product.getTitle())
                .build();
    }

    public static ProductDTO mapToProductDTO(DummyJSONProductDTO dummyJSONProductDTO) throws IOException {
        return ProductDTO.builder()
                .id(dummyJSONProductDTO.getId())
                .name(dummyJSONProductDTO.getTitle())
                .build();
    }
}
