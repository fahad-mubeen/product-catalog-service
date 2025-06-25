package com.project.thirdpartyserver.configuration;

import com.project.thirdpartyserver.gateway.api.DummyJSONProductAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public DummyJSONProductAPI dummyJSONProductAPI(Retrofit retrofit) {
        return retrofit.create(DummyJSONProductAPI.class);
    }
}
