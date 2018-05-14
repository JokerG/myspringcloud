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
    @Component
    class ConsumerService {
        @Autowired
        private RestTemplate restTemplate;

        @HystrixCommand(fallbackMethod = "fallback")
        public String degrade(){
            return restTemplate.getForObject("http://eureka-client/degrade", String.class);
        }

        public String fallback(){
            return "fallback";
        }

    }
}
