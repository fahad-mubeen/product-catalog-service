package com.project.thirdpartyserver.gateway.api;

import com.project.thirdpartyserver.dto.FakestoreProductWrapperDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;

public interface FakestoreProductAPI {
    @GET("products")
    Call<FakestoreProductWrapperDTO> getAllProducts() throws IOException;
}
