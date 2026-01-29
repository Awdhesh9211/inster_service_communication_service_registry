package com.learn.consumer.resttemplate;


import com.learn.consumer.service.RestTemplateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/rt")
public class RestTemplateController {

    @Autowired
    private RestTemplateClient restTemplateClient;

    @GetMapping("/instance")
    public String getInstance(){
        return restTemplateClient.getInstance();
    }
}
