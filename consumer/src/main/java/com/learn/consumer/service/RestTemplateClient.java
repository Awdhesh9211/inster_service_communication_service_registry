package com.learn.consumer.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateClient {

    @Value("${provider.base.url}")
    private  String provide_base_uri;


    private final RestTemplate restTemplate;

    public RestTemplateClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getInstance(){
        return restTemplate.getForObject(provide_base_uri+"/provider/instance/info",String.class);
    }
}
