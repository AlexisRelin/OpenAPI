package com.example.openapigenerator.configuration;

import com.example.openapigenerator.product.client.api.InfoApi;
import com.example.openapigenerator.product.client.api.StorageApi;
import com.example.openapigenerator.product.client.ApiClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration(proxyBeanMethods = false)
public class ProductConfiguration {

    private static final String WEB_CLIENT = "webClient";

    private static final String PRODUCT_API_CLIENT = "productApiClient";
    private static final String PRODUCT_INFO_CLIENT = "productInfoClient";
    private static final String PRODUCT_STORAGE_CLIENT = "productStorageClient";

    @Bean(name = PRODUCT_API_CLIENT)
    ApiClient productApiClient(@Qualifier(WEB_CLIENT) WebClient webclient) {
        ApiClient apiClient = new ApiClient(webclient);
        return apiClient;
    }

    @Bean(name = PRODUCT_INFO_CLIENT)
    InfoApi productInfoApi() {
        return new InfoApi();
    }

    @Bean(name = PRODUCT_STORAGE_CLIENT)
    StorageApi productStorageApi() {
        return new StorageApi();
    }

}
