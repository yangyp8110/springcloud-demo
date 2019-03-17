package com.springcloud.singlehystrix;

import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mr.yang on 2019/3/3.
 */
@Configuration
public class HystrixConfig {
    /**
     * 用来像监控中心Dashboard发送stream信息
     *
     * A {@link ServletContextInitializer} to register {@link Servlet}s in a Servlet 3.0+ container.
     */
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        return new ServletRegistrationBean(new HystrixMetricsStreamServlet(), "/hystrix.stream");
    }

    /**
     * 用来拦截处理HystrixCommand注解
     *
     * AspectJ aspect to process methods which annotated with {@link HystrixCommand} annotation.
     *
     * {@link HystrixCommand} annotation used to specify some methods which should be processes as hystrix commands.
     */
    @Bean
    public HystrixCommandAspect hystrixCommandAspect() {
        return new HystrixCommandAspect();
    }
}
