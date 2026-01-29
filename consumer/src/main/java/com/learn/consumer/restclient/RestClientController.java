package com.learn.consumer.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer/rc")
public class RestClientController {

    private final RestClientService restClientService;

    public RestClientController(RestClientService restClientService) {
        this.restClientService = restClientService;
    }

    @GetMapping("/instance")
    public String getInstance() {
        return restClientService.getInstance();
    }
}
