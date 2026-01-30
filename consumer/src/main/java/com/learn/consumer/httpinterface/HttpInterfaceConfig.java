package com.learn.consumer.httpinterface;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class HttpInterfaceConfig {

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return  new RestTemplate();
//    }


    @Bean
    public ProviderHttpInterface  webClientHttpInterface(RestTemplate restTemplate){
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://provider"));
        RestTemplateAdapter adapter=RestTemplateAdapter.create(restTemplate);
        HttpServiceProxyFactory factory=HttpServiceProxyFactory.builderFor(adapter).build();

        ProviderHttpInterface service=factory.createClient(ProviderHttpInterface.class);
        return service;
    }
}
