package com.hjx.springcloud.controller;

import com.hjx.entities.Dept;
import com.hjx.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dept/list")
    public List<Dept> list() {
        List<Dept> all = deptService.findAll();
        System.out.println(1111111111);
        return all;
    }

    @PostMapping("/dept/add")
    public boolean addDept(@RequestBody Dept dept) {
        System.out.println(22222);
        return deptService.addDept(dept);
    }



    @GetMapping("/dept/{id}")
    public Dept findById(@PathVariable("id") Long deptId) {
        return deptService.findById(deptId);
    }

    ;

    @GetMapping("/dept/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        // System.out.println("================"+services);
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        for (String service : services) {
            System.out.println("service===" + service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            System.out.println(instances);
            for (ServiceInstance instance : instances) {
//                System.out.println(instance.getHost()+"   "+instance.getUri()+" "
//                        +instance.getPort());
                stringBuffer.append("第" + (i++) + "个服务：" + instance.getServiceId() + "----" +
                        instance.getHost() + " ----- " +
                        instance.getUri() + "----- "
                        + instance.getPort());

                stringBuffer.append("<br/>");
            }
            //  stringBuffer.append("aaa");
        }
        return stringBuffer.toString();
    }

}
