package com.hjx.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value ="MICRO-SPRINGCLOUD-PROVIDER-DEPT-8001" )
public interface DeptConsumerFeignSerivce {
    @GetMapping("/dept/list")
    public List list();


    @GetMapping("/dept/discovery")
    public String discovery() ;
}
