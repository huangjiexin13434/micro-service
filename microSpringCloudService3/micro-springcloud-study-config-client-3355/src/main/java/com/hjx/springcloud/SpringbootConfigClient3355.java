package com.hjx.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootConfigClient3355 {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootConfigClient3355.class, args);
    }
}
