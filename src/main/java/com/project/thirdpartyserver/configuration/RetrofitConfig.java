package com.project.thirdpartyserver.configuration;

import com.project.thirdpartyserver.gateway.api.DummyJSONProductAPI;
import com.project.thirdpartyserver.gateway.api.FakestoreProductAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    // Retrofit for DummyJSON
    @Bean
    public Retrofit dummyJsonRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public DummyJSONProductAPI dummyJSONProductAPI(Retrofit dummyJsonRetrofit) {
        return dummyJsonRetrofit.create(DummyJSONProductAPI.class);
    }

    // Retrofit for FakeStore
    @Bean
    public Retrofit fakeStoreRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakestoreProductAPI fakeStoreProductAPI(Retrofit fakeStoreRetrofit) {
        return fakeStoreRetrofit.create(FakestoreProductAPI.class);
    }
}
