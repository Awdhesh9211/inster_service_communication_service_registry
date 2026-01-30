package com.learn.consumer.restclient;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class RestClientService {

    private final DiscoveryClient discoveryClient;
    private final RestClient restClient;

    // round-robin counter
    private final AtomicInteger position = new AtomicInteger(0);

    public RestClientService(
            DiscoveryClient discoveryClient,
            RestClient.Builder restClientBuilder) {

        this.discoveryClient = discoveryClient;
        this.restClient = restClientBuilder.build();
    }

    public String getInstance() {

        List<ServiceInstance> instances =
                discoveryClient.getInstances("provider");

        if (instances == null || instances.isEmpty()) {
            throw new IllegalStateException("Provider service is not available");
        }

        // ---- LOAD BALANCING HERE ----
        int index = Math.abs(position.getAndIncrement() % instances.size());
        ServiceInstance instance = instances.get(index);
        // ----------------------------

        return restClient.get()
                .uri(instance.getUri() + "/provider/instance/info")
                .retrieve()
                .body(String.class);
    }
}
