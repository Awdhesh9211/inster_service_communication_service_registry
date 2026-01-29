package com.learn.consumer.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RefreshScope
public class RestClientService {

    private final RestClient restClient;
//    @Value("${provider.base.url}")
//    private  String providerBaseUrl;

    public RestClientService(
            RestClient restClient) {
        this.restClient = restClient;
    }

    public String getInstance() {
        return restClient
                .get()
                .uri("http://localhost:8082/provider/instance/info")
                .retrieve()
                .body(String.class);
    }
}
