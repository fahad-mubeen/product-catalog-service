package com.project.thirdpartyserver.gateway.api;

import com.project.thirdpartyserver.dto.DummyJSONProductWrapperDTO;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.List;

public interface DummyJSONProductAPI {
    @GET("products")
    Call<DummyJSONProductWrapperDTO> getAllProducts() throws IOException;
}
