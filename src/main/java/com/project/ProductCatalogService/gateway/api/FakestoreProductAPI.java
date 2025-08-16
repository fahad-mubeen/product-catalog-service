package com.project.ProductCatalogService.gateway.api;

import com.project.ProductCatalogService.dto.FakestoreAllProductWrapperDTO;
import com.project.ProductCatalogService.dto.FakestoreSingleProductWrapperDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakestoreProductAPI {
    @GET("products")
    Call<FakestoreAllProductWrapperDTO> getAllProducts() throws IOException;

    @GET("products/{id}")
    Call<FakestoreSingleProductWrapperDTO> getProductById(@Path("id") Long id) throws IOException;
}
