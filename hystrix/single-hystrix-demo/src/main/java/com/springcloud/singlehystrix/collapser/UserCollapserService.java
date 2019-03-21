package com.springcloud.singlehystrix.collapser;

import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.singlehystrix.cache.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mr.yang on 2019/3/19.
 */
@Service
public class UserCollapserService {

    @HystrixCollapser(batchMethod = "batchGetUser", collapserProperties = {
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "10000")
    })
    public User getUserByUserId(Integer userId) {

        return new User(99999, "unknown", System.currentTimeMillis());
    }

    @HystrixCommand
    public List<User> batchGetUser(List<Integer> userIds) {
        System.out.println(userIds);
        List<User> collect = userDatas.stream().filter(x -> userIds.contains(x.getUserId())).collect(Collectors.toList());
        return collect;
    }

    public static List<User> userDatas = Lists.newArrayList(
            new User(1001, "张三", System.currentTimeMillis()),
            new User(1002, "李四", System.currentTimeMillis()),
            new User(1003, "王五", System.currentTimeMillis()),
            new User(1004, "赵六", System.currentTimeMillis())
    );
}
