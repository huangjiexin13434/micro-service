package com.hjx.springcloud.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;
/*
    改成每次5次才随机轮询
 */
public class MyRule extends AbstractLoadBalancerRule {
    Random rand = new Random();

    public MyRule() {
    }
    int index=0;
    int total=0;
    int currentIndex=0;
    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();

                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }


//                System.out.println("upLI   "+upList);
//                System.out.println("allList   "+allList);
//                int index = this.rand.nextInt(serverCount);
//                server = (Server)upList.get(index);

                if(total<5){
                    total++;
                    if(currentIndex==0){
                        currentIndex=serverCount-1;
                    }
                    index = currentIndex;
//                    System.out.println("1====="+index+"  total "+total);
                    server = (Server)upList.get(index);
                }else{
                    total=0;
                    index = this.rand.nextInt(serverCount);
//                    System.out.println("2====="+index+"  total "+total);
                    server = (Server)upList.get(index);
                }
                currentIndex=index;

                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
