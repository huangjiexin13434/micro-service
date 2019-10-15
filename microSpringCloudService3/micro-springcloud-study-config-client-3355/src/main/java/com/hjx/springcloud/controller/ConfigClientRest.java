package com.hjx.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServers;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/config")
    public String getConfig(){
        System.out.println("applicationName:"+this.applicationName
                +"        eurekaServers:"+this.eurekaServers
                +"          port:"+this.port);
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("applicationName");
        stringBuffer.append(this.applicationName)
        .append("\r\n");
        stringBuffer.append("eurekaServers");
        stringBuffer.append(this.eurekaServers)
                .append("\n");
        stringBuffer.append("port");
        stringBuffer.append(this.port)
                .append("\r\n");
        return stringBuffer.toString();
    }
}
