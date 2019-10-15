package com.hjx.springcloud;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@RestController

@EnableFeignClients
public class SpringbootinitializerApplicationFeigh81 {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootinitializerApplicationFeigh81.class, args);

    }

}
