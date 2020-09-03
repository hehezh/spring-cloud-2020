package com.zhang.springcloud.service;

import com.zhang.springcloud.entities.CommonResult;
import com.zhang.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-03 11:58
 * @Version 1.0
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();

}
