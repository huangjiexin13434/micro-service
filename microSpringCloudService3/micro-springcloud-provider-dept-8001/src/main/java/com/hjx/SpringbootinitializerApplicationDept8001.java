package com.hjx;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication()
@EnableEurekaClient
public class SpringbootinitializerApplicationDept8001 {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootinitializerApplicationDept8001.class, args);
    }

}
