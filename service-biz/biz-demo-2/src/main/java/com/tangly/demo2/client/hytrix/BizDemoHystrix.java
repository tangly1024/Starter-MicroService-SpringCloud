package com.tangly.demo2.client.hytrix;

import com.tangly.demo2.client.BizDemoClient;
import org.springframework.stereotype.Component;

@Component
public class BizDemoHystrix implements BizDemoClient {
    @Override
    public String config() {
        return "无法获取远端配置";
    }
}
