package com.tangly.demo2.client;

import com.tangly.demo2.FeignConfig;
import com.tangly.demo2.client.hytrix.DemoServiceHytrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "biz-demo",configuration = FeignConfig.class,fallback = DemoServiceHytrix.class)
public interface DemoClient {

    @GetMapping("/config")
    String config();

}
