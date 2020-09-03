package com.zhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-03 14:24
 * @Version 1.0
 **/
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class OrderHystrixMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain90.class, args);
    }
}
