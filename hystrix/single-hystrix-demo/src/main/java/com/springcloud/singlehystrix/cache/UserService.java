package com.springcloud.singlehystrix.cache;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import org.springframework.stereotype.Service;

/**
 *
 * @author mr.yang
 * @date 2019/3/17
 */
@Service
public class UserService {
    @HystrixCommand(fallbackMethod = "getFallback")
    @CacheResult(cacheKeyMethod = "getCacheKey")
    public User getUserByUserId(Integer userId) {
        System.out.println("========== UserService get user run ==========");
        return new User(userId, "小明", System.currentTimeMillis());
    }

    public String getCacheKey(Integer userId) {
        return String.valueOf(userId);
    }

    public User getFallback(Integer userId) {
        return new User(9999, "fail", System.currentTimeMillis());
    }
}
