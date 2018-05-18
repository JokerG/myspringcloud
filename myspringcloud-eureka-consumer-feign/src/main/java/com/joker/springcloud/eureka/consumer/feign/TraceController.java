package com.joker.springcloud.eureka.consumer.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TraceController {
    @Autowired
    private DcClient dcClient;

    @GetMapping("/trace")
    public String trace(){
        return dcClient.trace();
    }
}
