package com.learn.consumer.resttemplate;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced    // resolve by eureka
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
