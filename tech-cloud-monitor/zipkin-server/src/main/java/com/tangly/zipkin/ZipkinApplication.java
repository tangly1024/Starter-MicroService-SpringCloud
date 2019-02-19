package com.tangly.zipkin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;
import org.springframework.core.env.Environment;

@EnableZipkinStreamServer
@SpringBootApplication
@EnableDiscoveryClient
public class ZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
    }

    @Autowired
    private void env(Environment env){
        System.err.println(env.getProperty("myconfig.tangly"));

    }
}
