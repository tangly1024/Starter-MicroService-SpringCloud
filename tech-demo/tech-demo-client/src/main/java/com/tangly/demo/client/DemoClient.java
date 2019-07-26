package com.tangly.demo.client;

import com.tangly.demo.vo.DemoPageIVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "tech-demo-server")
@Api(tags = "测试")
public interface DemoClient {

    /**
     * https://xbuba.com/questions/35621062
     * OpenFeign @QueryMap注释为POJO提供了支持，可用作GET参数映射。
     * <p>
     * Spring Cloud OpenFeign提供了一个等效的@SpringQueryMap注释，用于从2.1.0开始将POJO或Map参数注释为查询参数图。
     * <p>
     * 你可以像这样使用它：
     */
    @ApiOperation(value = "查询Demo")
    @RequestMapping(value = "/query", method = RequestMethod.GET)
    String query(@SpringQueryMap DemoPageIVO ivo);
}
