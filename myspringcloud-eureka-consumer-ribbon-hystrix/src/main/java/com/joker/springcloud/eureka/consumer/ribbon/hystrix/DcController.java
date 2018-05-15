package com.joker.springcloud.eureka.consumer.ribbon.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {
    @Autowired(required = false)
    private  ConsumerService consumerService;

    @GetMapping("/degrade")
    public String degrade() {
        return consumerService.degrade();
    }
 @GetMapping("/consumer")
    public String consumer() {
        return consumerService.degrade();
    }
    @Component
    class ConsumerService {
        @Autowired
        private RestTemplate restTemplate;

        /**
         * 已实现依赖隔离 可以通过execution.isolation.strategy 配置策略
         * @return
         */
        @HystrixCommand(fallbackMethod = "fallback")
        public String degrade(){
            return restTemplate.getForObject("http://eureka-client/degrade", String.class);
        }
        @HystrixCommand(fallbackMethod = "fallback")
        public  String consumer(){
            return restTemplate.getForObject("http://eureka-client/dc", String.class);
        }

        public String fallback(){
            return "fallback";
        }

    }
}
