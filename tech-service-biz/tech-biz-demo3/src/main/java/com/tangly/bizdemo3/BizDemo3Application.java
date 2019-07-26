package com.tangly.bizdemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class BizDemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(BizDemo3Application.class, args);
    }

}
