package com.hjx.springcloud.config;

import com.hjx.springcloud.rule.MyRule;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
//    @Bean
//    public IRule myRule(){
//        return  new AvailabilityFilteringRule();
//    }
    @Bean
    public IRule myRule(){
        return  new MyRule();
    }
}
