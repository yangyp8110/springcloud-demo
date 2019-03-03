package com.springcloud.peer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by mr.yang on 2019/3/2.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerPeer1Application {
    public static void main(String[] args) {
        SpringApplication.run( EurekaServerPeer1Application.class, args );
    }
}
