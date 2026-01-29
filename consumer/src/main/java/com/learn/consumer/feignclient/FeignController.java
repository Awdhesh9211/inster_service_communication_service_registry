package com.learn.consumer.feignclient;




import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/feign")
public class FeignController {

    private final ProviderFeignClient providerFeignClient;

    public FeignController(ProviderFeignClient providerFeignClient) {
        this.providerFeignClient = providerFeignClient;
    }

    @GetMapping("/instance")
    public String getInstance() {
        return providerFeignClient.getInstanceInfo();
    }


}
