package com.springcloud.ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mr.yang on 2019/3/3.
 */
@Configuration
public class MyRibbonConfig {
    @Bean
    public IRule ribbonRule() {

        return new RandomRule();
    }
}
