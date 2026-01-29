package com.learn.consumer.httpinterface;


import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface ProviderHttpInterface {
    @GetExchange("/provider/instance/info")
    String getInstanceInfo();
}
