package com.joker.springcloud.eureka.consumer.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * feign 基于ribbon，支持负载均衡，亦可通过IRule进行策略扩展，
 *同时整合了Hystrix来实现服务的容错保护
 *
 */
@FeignClient(value = "eureka-client",fallback = DcFallBack.class)
public interface DcClient {
    @GetMapping("/dc")
    String dc();

    @GetMapping("/trace2")
    String trace();
}
