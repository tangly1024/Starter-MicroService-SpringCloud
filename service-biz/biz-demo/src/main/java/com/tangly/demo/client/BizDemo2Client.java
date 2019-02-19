package com.tangly.demo.client;

import com.tangly.demo.FeignConfig;
import com.tangly.demo.client.hytrix.BizDemo2Hystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "biz-demo2", configuration = FeignConfig.class, fallback = BizDemo2Hystrix.class)
public interface BizDemo2Client {

    @GetMapping("/plus")
    Integer plus(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
