package com.hjx.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController
@EnableEurekaClient
@EnableZuulProxy
public class SpringbootZuulGateway9527 {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootZuulGateway9527.class, args);
    }
    @RequestMapping("/b")
    public String b(){
        return " bbbbbbbbbbbbbb";
    }
}
