package com.zhang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-03 17:10
 * @Version 1.0
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----PaymentFallbackService------- fall back paymentInfo_OK";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "-----PaymentFallbackService------- fall back paymentInfo_Timeout";
    }
}
