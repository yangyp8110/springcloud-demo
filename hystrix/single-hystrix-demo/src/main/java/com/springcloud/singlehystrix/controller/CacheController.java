package com.springcloud.singlehystrix.controller;

import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategy;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.springcloud.singlehystrix.cache.UserCommand;
import com.springcloud.singlehystrix.cache.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mr.yang on 2019/3/2.
 */
@RestController
public class CacheController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUserCommandByUserId/{userId}")
    public String getUserCommand(@PathVariable Integer userId) {
        HystrixRequestContext.initializeContext();

        System.out.println(new UserCommand(userId).execute().toString());
        System.out.println(new UserCommand(userId).execute().toString());
        System.out.println(new UserCommand(userId).execute().toString());
        System.out.println(new UserCommand(userId).execute().toString());

        return new UserCommand(userId).execute().toString();
    }

    @GetMapping("/getUserByUserId/{userId}")
    public String getUserByUserId(@PathVariable Integer userId) {
        HystrixRequestContext.initializeContext();

        System.out.println(userService.getUserByUserId(userId));
        System.out.println(userService.getUserByUserId(userId));
        System.out.println(userService.getUserByUserId(userId));

        return userService.getUserByUserId(userId).toString();
    }
}
