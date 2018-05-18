package com.joker.springcloud.eureka.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TraceController {
    private static final Logger logger = LoggerFactory
            .getLogger(TraceController.class);

    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/trace2")
    public String trace1() {
        logger.info("===<call trace-2>===");
        return restTemplate.getForObject("http://eureka-client/trace1",String.class);
    }
}
