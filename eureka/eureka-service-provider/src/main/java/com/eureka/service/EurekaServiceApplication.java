package com.eureka.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by mr.yang on 2019/3/2.
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run( EurekaServiceApplication.class, args );
    }
}

