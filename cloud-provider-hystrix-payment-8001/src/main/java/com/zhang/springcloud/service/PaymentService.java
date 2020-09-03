package com.zhang.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-03 14:43
 * @Version 1.0
 **/
@Service
public class PaymentService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK，id：" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String paymentInfo_Timeout(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_Timeout，id：" + id;
    }

    public String paymentInfo_TimeoutHandler(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 8001系统繁忙，请稍后再试，id：" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  //是否开启断路器
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "10000"),   //时间窗口
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),  //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),   //达到熔断后的睡眠时间
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),      //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("***********id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + " 调用成功，流水号：" + serialNumber;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试！ id:" + id;
    }

}
