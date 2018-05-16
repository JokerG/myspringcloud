package com.joker.springcloud.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {
    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "[Eureka-Client-1] Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/degrade")
    public String degrade() {
        try {
            //休眠5秒，模拟服务降级
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "degrade";
    }
}
