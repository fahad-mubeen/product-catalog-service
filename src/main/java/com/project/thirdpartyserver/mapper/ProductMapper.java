package com.project.thirdpartyserver.mapper;

import com.project.thirdpartyserver.dto.*;
import com.project.thirdpartyserver.entity.Category;
import com.project.thirdpartyserver.entity.Product;

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
                    .categoryId(-1L) // Fakestore does not provide category ID in the product list
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
                    .categoryId(-1L) // DummyJSON does not provide category ID
                    .build();
            productDTOList.add(productDTO);
        }

        return productDTOList;
    }

    public static List<ProductDTO> mapToProductDTOList(List<Product> productList) {
        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .categoryId(product.getCategory().getId())
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
                .categoryId(-1L) // Fakestore does not provide category ID in the product details
                .build();
    }

    public static ProductDTO mapToProductDTO(DummyJSONProductDTO dummyJSONProductDTO) throws IOException {
        return ProductDTO.builder()
                .id(dummyJSONProductDTO.getId())
                .name(dummyJSONProductDTO.getTitle())
                .categoryId(-1L) // DummyJSON does not provide category ID
                .build();
    }

    public static ProductDTO mapToProductDTO(Product product) throws IOException {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .categoryId(product.getCategory().getId())
                .build();
    }

    public static Product mapToProduct(ProductDTO productDTO, Category category) throws IOException {
        return Product.builder()
                .name(productDTO.getName())
                .category(category)
                .build();
    }
}
