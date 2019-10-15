package com.hjx.springcloud.controller;

import com.hjx.entities.Dept;
import com.hjx.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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


    @HystrixCommand(fallbackMethod = "produceErrorMethod")
    @GetMapping("/dept/{id}")
    public Dept findById(@PathVariable("id") Long deptId)throws Exception {
        Dept dept=deptService.findById(deptId);
        if(dept==null||"".equals(dept)){
            //throw new Exception(deptId+"");
            throw new Exception("sssssssssssssssss");
        }
        return dept;
    }
    public Dept produceErrorMethod(Long deptId){
        System.out.println("eeeeeeeeeeeeeeeeeeeeee");
        Dept dept=new Dept();
        dept.setDeptName("dept为空");
        dept.setDbSource("数据库无该数据");
        return  dept;
    }
    public Dept produceErrorMethod(String deptId){
        System.out.println("aaaaaaaaaaaaaaaaa");
        Dept dept=new Dept();
        dept.setDeptName("dept为空1111111111111");
        dept.setDbSource("数据库无该数据1111");
        return  dept;
    }


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
