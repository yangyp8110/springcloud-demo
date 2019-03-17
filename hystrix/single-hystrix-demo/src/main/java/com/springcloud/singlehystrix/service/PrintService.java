package com.springcloud.singlehystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.springcloud.singlehystrix.exception.BizException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * Created by mr.yang on 2019/3/3.
 */
@Service
public class PrintService {

    @HystrixCommand(fallbackMethod = "printFallBack")
    public String print(String result) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(new Random().nextInt(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start));
        return result + "\n print finished ! time : " + new Date();
    }

    public String printFallBack(String msg) {
        return "print error !" + msg + " time : " + new Date();
    }

    @HystrixCommand(fallbackMethod = "printFallBack", ignoreExceptions = {BizException.class})
    public String error(String result) {
//        throw new BizException(9999, result);
        throw new HystrixBadRequestException("HystrixBadRequestException" + result);
    }
}
