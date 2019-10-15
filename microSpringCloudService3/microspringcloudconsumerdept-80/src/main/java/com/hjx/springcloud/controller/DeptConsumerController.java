package com.hjx.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
     //public static final  String PROVIDER_ADDRESS="http://localhost:8001";
    public static final String PROVIDER_ADDRESS = "http://MICRO-SPRINGCLOUD-PROVIDER-DEPT-8001";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/dept/list")
    public List list() {
        System.out.println("8080");
        return restTemplate.getForObject(PROVIDER_ADDRESS + "/dept/list", List.class);
    }

    @GetMapping("/a")
    public String a() {
        System.out.println(444);
        return "a";
    }

    @GetMapping("/consumer/dept/discovery")
    public String discovery() {
        return restTemplate.getForObject(PROVIDER_ADDRESS + "/dept/discovery",
                String.class);
    }
}
