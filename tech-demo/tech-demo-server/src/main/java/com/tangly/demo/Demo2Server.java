package com.tangly.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@SpringBootApplication
public class Demo2Server {

    public static void main(String[] args) {
        SpringApplication.run(Demo2Server.class,
                "--server.port=8082");

    }

}
