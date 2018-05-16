package com.joker.springcloud.eureka.consumer.feign;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.stereotype.Component;

@Component
public class DcFallBack implements DcClient{

    @Override
    public String dc() {
        return "fallback";
    }
}
