package com.tangly.demo.api;

import com.tangly.demo.client.DemoClient;
import com.tangly.demo.vo.DemoPageIVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApi {

    @Autowired
    private DemoClient demoClient;

    @GetMapping("demo")
    @ApiOperation(value = "对外接口")
    public String demo(@ModelAttribute DemoPageIVO ivo) {
        return demoClient.query(ivo);
    }

}
