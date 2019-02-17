package com.tangly.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("biz-demo-2")
public interface Demo2ServiceClient {

    @GetMapping("/plus")
    Integer plus(@RequestParam(value = "a")Integer a,@RequestParam(value = "b") Integer b);
}
