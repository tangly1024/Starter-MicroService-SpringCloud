package com.tangly.demo2.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Demo2服务测试")
@Slf4j
public class Demo2Controller {

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

}
