package com.tangly.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class DemoClientApp {
    public static void main(String[] args) {
        SpringApplication.run(DemoClientApp.class, args);
    }
}
