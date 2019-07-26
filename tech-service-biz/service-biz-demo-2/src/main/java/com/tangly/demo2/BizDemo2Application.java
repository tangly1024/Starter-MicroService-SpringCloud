package com.tangly.demo2;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication
@EnableFeignClients
//@EnableHystrixDashboard
public class BizDemo2Application {
    public static void main(String[] args) {
        SpringApplication.run(BizDemo2Application.class, args);
    }
}
