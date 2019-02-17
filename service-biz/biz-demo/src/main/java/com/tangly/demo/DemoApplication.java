package com.tangly.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

@SpringCloudApplication
@EnableFeignClients
@EnableHystrixDashboard
public class DemoApplication {

    @Autowired
    private void setEnvironment(Environment environment){
        System.out.println(environment.getProperty("server.port"));
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

