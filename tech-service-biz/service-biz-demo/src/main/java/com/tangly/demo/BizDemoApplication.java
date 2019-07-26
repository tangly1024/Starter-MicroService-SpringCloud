package com.tangly.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringCloudApplication
//@EnableHystrixDashboard
public class BizDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BizDemoApplication.class, args);
    }

}

