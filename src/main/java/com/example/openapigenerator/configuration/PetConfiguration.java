package com.example.openapigenerator.configuration;

import com.example.openapigenerator.pet.client.ApiClient;
import com.example.openapigenerator.pet.client.api.InfoApi;
import com.example.openapigenerator.pet.client.api.StorageApi;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.HttpComponentsClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration(proxyBeanMethods = false)
public class PetConfiguration {

    private static final String WEB_CLIENT = "webClient";

    private static final String PET_API_CLIENT = "petApiClient";
    private static final String PET_INFO_CLIENT = "petInfoClient";
    private static final String PET_STORAGE_CLIENT = "petStorageClient";

    @Bean(name = WEB_CLIENT)
    WebClient webClient() {
        return WebClient.builder()
                .clientConnector(new HttpComponentsClientHttpConnector())
                .build();
    }

    @Bean(name = PET_API_CLIENT)
    ApiClient petApiClient(@Qualifier(WEB_CLIENT) WebClient webclient) {
        ApiClient apiClient = new ApiClient(webclient);
        return apiClient;
    }

    @Bean(name = PET_INFO_CLIENT)
    InfoApi petInfoApi() {
        return new InfoApi();
    }

    @Bean(name = PET_STORAGE_CLIENT)
    StorageApi petStorageApi() {
        return new StorageApi();
    }
}
