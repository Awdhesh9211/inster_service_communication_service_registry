package com.learn.consumer.controller;


import com.learn.consumer.client.FeignClientInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/feign")
public class FeignController {

    @Autowired
    private FeignClientInterface feignClientInterface;

    @GetMapping("/instance")
    public String getInstance(){
        return feignClientInterface.getInstanceInfo();
    }


}
