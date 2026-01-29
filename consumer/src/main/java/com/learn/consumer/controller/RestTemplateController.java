package com.learn.consumer.controller;


import com.learn.consumer.service.RestTemplateClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/rt")
public class RestTemplateController {

    private RestTemplateClient restTemplateClient;

    public RestTemplateController(RestTemplateClient restTemplateClient) {
        this.restTemplateClient = restTemplateClient;
    }

    @GetMapping("/instance")
    public String getInstance(){
        return restTemplateClient.getInstance();
    }
}
