package com.joker.springboot.consul.client;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * consul 启动命令：consul agent -dev
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class,args);
    }
}
