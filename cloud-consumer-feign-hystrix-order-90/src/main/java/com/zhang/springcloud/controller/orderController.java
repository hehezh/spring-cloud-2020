package com.zhang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zhang.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-03 15:48
 * @Version 1.0
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentTimeoutGlobalFallbackMethod")
public class orderController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        int age = 10/0;
        return paymentHystrixService.paymentInfo_Timeout(id);
    }

    public String paymentTimeoutFallbackMethod(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " 90系统繁忙，请稍后再试，id：" + id;
    }

    public String paymentTimeoutGlobalFallbackMethod() {
        return "全局异常处理信息，请稍后再试！！！！！！";
    }

}
