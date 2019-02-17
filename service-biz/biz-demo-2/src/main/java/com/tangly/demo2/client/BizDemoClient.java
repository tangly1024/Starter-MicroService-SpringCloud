package com.tangly.demo2.client;

import com.tangly.demo2.FeignConfig;
import com.tangly.demo2.client.hytrix.BizDemoHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "biz-demo",configuration = FeignConfig.class,fallback = BizDemoHystrix.class)
public interface BizDemoClient {

    @GetMapping("/config")
    String config();

}
