package com.tangly.demo2.client.hytrix;

import com.tangly.demo2.client.DemoClient;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceHytrix implements DemoClient {
    @Override
    public String config() {
        return "没有配置";
    }
}
