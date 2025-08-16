package com.project.ProductCatalogService.gateway.api;

import com.project.ProductCatalogService.dto.DummyJSONProductDTO;
import com.project.ProductCatalogService.dto.DummyJSONProductWrapperDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface DummyJSONProductAPI {
    @GET("products")
    Call<DummyJSONProductWrapperDTO> getAllProducts() throws IOException;

    @GET("products/{id}")
    Call<DummyJSONProductDTO> getProductById(@Path("id") Long id) throws IOException;
}
