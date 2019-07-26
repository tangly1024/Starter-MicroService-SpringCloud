package com.tangly.demo.controller;

import com.tangly.demo.service.IDemoService;
import com.tangly.demo.vo.DemoPageIVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RefreshScope
@RestController
@Slf4j
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @Value("${myconfig.tangly:''}")
    private String tangly;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("query")
    public String query(@ModelAttribute DemoPageIVO ivo) {
        return "端口" + serverPort + " 配置" + tangly + " " + demoService.getDemo(ivo);
    }
}
