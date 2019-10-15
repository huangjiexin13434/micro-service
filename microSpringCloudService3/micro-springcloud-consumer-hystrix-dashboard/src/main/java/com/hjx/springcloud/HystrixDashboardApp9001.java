package com.hjx.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableHystrixDashboard
public class HystrixDashboardApp9001 {

    public static void main(String[] args) {

        SpringApplication.run(HystrixDashboardApp9001.class, args);
    }

}
