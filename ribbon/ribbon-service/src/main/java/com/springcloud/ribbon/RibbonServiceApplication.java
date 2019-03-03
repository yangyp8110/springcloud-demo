package com.springcloud.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mr.yang on 2019/3/2.
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(value = "service-1", configuration = MyRibbonConfig.class)
public class RibbonServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run( RibbonServiceApplication.class, args );
    }

    /**
     * 实例化RestTemplate，通过@LoadBalanced注解开启均衡负载
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

