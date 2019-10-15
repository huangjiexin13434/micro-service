package com.hjx.springcloud.controller;

import com.hjx.springcloud.service.DeptConsumerFeignSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerFeignController {
    @Autowired
    private DeptConsumerFeignSerivce deptConsumerFeignSerivce;
    @GetMapping("/feign/dept/list")
    public List list() {
        return  deptConsumerFeignSerivce.list();
    }


    @GetMapping("/feign/dept/discovery")
    public String discovery() {
        return deptConsumerFeignSerivce.discovery();
    }
}
