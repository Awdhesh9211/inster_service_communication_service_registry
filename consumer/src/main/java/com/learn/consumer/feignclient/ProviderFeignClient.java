package com.learn.consumer.feignclient;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "provider-service" , url = "http://localhost:8082")

@FeignClient(name = "provider-service" , url = "http://provider")
public interface ProviderFeignClient {


    @GetMapping("/provider/instance/info")
    String getInstanceInfo();
}
