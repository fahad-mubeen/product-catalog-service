package com.project.thirdpartyserver.gateway.api;

import com.project.thirdpartyserver.dto.DummyJSONProductDTO;
import com.project.thirdpartyserver.dto.DummyJSONProductWrapperDTO;
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
