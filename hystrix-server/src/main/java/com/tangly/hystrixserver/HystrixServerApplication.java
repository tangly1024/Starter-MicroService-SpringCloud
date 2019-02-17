package com.tangly.hystrixserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.core.env.Environment;

@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class HystrixServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixServerApplication.class, args);
    }

    @Autowired
    private void setEnv(Environment env){
        System.out.println("--------------->" + env.getProperty("myconfig.tangly"));
    }
}
