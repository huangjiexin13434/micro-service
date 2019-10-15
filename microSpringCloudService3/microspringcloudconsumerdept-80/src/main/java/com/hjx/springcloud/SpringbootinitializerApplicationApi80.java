package com.hjx.springcloud;


import com.hjx.springcloud.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableEurekaClient
@RestController
@RibbonClient(name="MICRO-SPRINGCLOUD-PROVIDER-DEPT-8001",configuration = MyRule.class)
public class SpringbootinitializerApplicationApi80 {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootinitializerApplicationApi80.class, args);
    }

    @RequestMapping("/")
    public String a() {
        return "ssssssss";
    }
}
