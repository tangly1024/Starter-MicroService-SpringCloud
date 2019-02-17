package com.tangly.demo2.controller;

import com.tangly.demo2.client.BizDemoClient;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Demo2服务测试")
@Slf4j
@RefreshScope
public class Demo2Controller {

    private final BizDemoClient bizDemoClient;

    @Autowired
    public Demo2Controller(BizDemoClient bizDemoClient) {
        this.bizDemoClient = bizDemoClient;
    }

    /**
     * 加法服务
     *
     * @return 两数之和
     */
    @GetMapping("plus")
    public Integer plusService(Integer a, Integer b) {
        log.info("调用了Demo2服务");
        return a + b;
    }

    @GetMapping("config")
    public String config(){
        return bizDemoClient.config();
    }

    @Value("${myconfig.tangly}")
    private String testConfigCenter;

    @GetMapping("center")
    public String center(){
        return testConfigCenter;
    }

}
