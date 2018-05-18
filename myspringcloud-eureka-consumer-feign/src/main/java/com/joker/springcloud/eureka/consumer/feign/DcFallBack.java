package com.joker.springcloud.eureka.consumer.feign;

import org.springframework.stereotype.Component;

@Component
public class DcFallBack implements DcClient{

    @Override
    public String dc() {
        return "fallback";
    }

    @Override
    public String trace() {
        return  "fallback";
    }
}
