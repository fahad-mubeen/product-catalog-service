package com.project.thirdpartyserver.configuration;

import com.project.thirdpartyserver.gateway.api.DummyJSONProductAPI;
import com.project.thirdpartyserver.gateway.api.FakestoreProductAPI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Value("${api.dummyjson.base-url}")
    private String dummyJsonBaseUrl;

    @Value("${api.fakestore.base-url}")
    private String fakestoreBaseUrl;

    // Retrofit for DummyJSON
    @Bean
    public Retrofit dummyJsonRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(dummyJsonBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public DummyJSONProductAPI dummyJSONProductAPI(Retrofit dummyJsonRetrofit) {
        return dummyJsonRetrofit.create(DummyJSONProductAPI.class);
    }

    // Retrofit for Fakestore
    @Bean
    public Retrofit fakeStoreRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(fakestoreBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakestoreProductAPI fakeStoreProductAPI(Retrofit fakeStoreRetrofit) {
        return fakeStoreRetrofit.create(FakestoreProductAPI.class);
    }
}
