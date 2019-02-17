package com.tangly.demo.client;

import com.tangly.demo.FeignConfig;
import com.tangly.demo.client.hytrix.Demo2Hystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "biz-demo-2", configuration = FeignConfig.class, fallback = Demo2Hystrix.class)
public interface Demo2Client {

    @GetMapping("/plus")
    Integer plus(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
