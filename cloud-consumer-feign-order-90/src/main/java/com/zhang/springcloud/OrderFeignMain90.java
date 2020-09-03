package com.zhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-03 11:49
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain90.class, args);
    }
}
