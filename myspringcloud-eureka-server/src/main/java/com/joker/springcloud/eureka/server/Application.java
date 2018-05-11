package com.joker.springcloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//springboot 应用
@SpringBootApplication
//Eureka Server
@EnableEurekaServer
public class Application {
    public static void main(String[]  args){
        SpringApplication.run(Application.class,args);
    }
}
