package com.zhang.springcloud.controller;

import com.zhang.springcloud.entities.CommonResult;
import com.zhang.springcloud.entities.Payment;
import com.zhang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-08-31 17:24
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/create")
    public CommonResult<String> create(Payment payment) {
        int result = paymentService.create(payment);
        log.info("***********插入结果：" + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功", result);
        }
        return new CommonResult(200, "插入数据库失败", null);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult(200, "查询成功", payment);
        }
        return new CommonResult(200, "没有对应记录，查询ID：" + id, null);
    }


}
