package com.tangly.demo.client.hytrix;

import com.tangly.demo.client.Demo2Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 服务调用失败、超时，回调默认值
 */
@Component
@Slf4j
public class Demo2Hystrix implements Demo2Client {

    @Override
    public Integer plus(Integer a, Integer b) {
        log.error("默认回调");
        return 0;
    }
}
