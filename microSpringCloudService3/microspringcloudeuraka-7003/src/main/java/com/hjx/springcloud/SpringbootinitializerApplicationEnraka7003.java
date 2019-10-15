package com.hjx.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RestController;

//exclude = DataSourceAutoConfiguration.class
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaServer
@RestController
public class SpringbootinitializerApplicationEnraka7003 {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootinitializerApplicationEnraka7003.class, args);
    }


}
