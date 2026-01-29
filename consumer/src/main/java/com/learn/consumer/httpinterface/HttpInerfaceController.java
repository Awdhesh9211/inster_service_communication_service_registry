package com.learn.consumer.httpinterface;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/hi")
public class HttpInerfaceController {

    private final ProviderHttpInterface providerHttpInterface;

    public HttpInerfaceController(ProviderHttpInterface providerHttpInterface) {
        this.providerHttpInterface = providerHttpInterface;
    }

    @GetMapping("/instance")
    public String getInstance(){
        return providerHttpInterface.getInstanceInfo();
    }
}
