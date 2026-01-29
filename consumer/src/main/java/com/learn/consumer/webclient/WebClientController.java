package com.learn.consumer.webclient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/consumer/wc")
public class WebClientController {


    private final ProviderWebClient providerWebClient;

    public WebClientController(ProviderWebClient providerWebClient) {
        this.providerWebClient = providerWebClient;
    }

    @GetMapping("/instance")
    public Mono<String> getInstance(){
        return providerWebClient.getInstance();
    }
}
