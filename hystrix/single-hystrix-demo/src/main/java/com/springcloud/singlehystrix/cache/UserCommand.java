package com.springcloud.singlehystrix.cache;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 *
 * @author mr.yang
 * @date 2019/3/17
 */
public class UserCommand extends HystrixCommand<User> {
    private Integer userId;

    @Override
    protected User run() throws Exception {
        System.out.println("========== get user run ==========");
        return new User(this.userId, "小明", System.currentTimeMillis());
    }

    public UserCommand(Integer userId) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("userGroup")));
        this.userId = userId;
    }

    @Override
    public String getCacheKey() {
        return String.valueOf(userId);
    }

    @Override
    public User getFallback() {
        return new User(9999, "fail", System.currentTimeMillis());
    }
}
