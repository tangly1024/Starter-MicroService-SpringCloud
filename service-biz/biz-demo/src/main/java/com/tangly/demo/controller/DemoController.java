package com.tangly.demo.controller;

import com.tangly.demo.ao.DemoAO;
import com.tangly.demo.bo.DemoBO;
import com.tangly.demo.client.BizDemo2Client;
import com.tangly.demo.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
@Slf4j
public class DemoController {

    private final IDemoService demoService;

    private final DiscoveryClient discoveryClient;

    private final BizDemo2Client bizDemo2Client;

    @Autowired
    public DemoController(IDemoService demoService, DiscoveryClient discoveryClient, BizDemo2Client bizDemo2Client) {
        this.demoService = demoService;
        this.discoveryClient = discoveryClient;
        this.bizDemo2Client = bizDemo2Client;
    }

    @GetMapping(value = "demo")
    public DemoAO demo(String query) {

        DemoBO bo = demoService.getDemoByQuery(query);
        DemoAO ao = new DemoAO();
        BeanUtils.copyProperties(bo, ao);
        ao.setService(discoveryClient.getServices());
        return ao;

    }

    @GetMapping(value = "plus")
    public DemoAO plus(Integer a, Integer b) {
        Integer result = bizDemo2Client.plus(a, b);
        return DemoAO.builder()
                .query(a + " + " + b)
                .result(String.valueOf(result))
                .service(discoveryClient.getServices())
                .build();
    }

    @Value("${myconfig.tangly}")
    private String testConfig;

    @GetMapping(value = "config")
    public DemoAO config() {
        log.info("调用了Demo1服务");
        return DemoAO.builder()
                .query("")
                .result(testConfig)
                .service(discoveryClient.getServices())
                .build();
    }
}
