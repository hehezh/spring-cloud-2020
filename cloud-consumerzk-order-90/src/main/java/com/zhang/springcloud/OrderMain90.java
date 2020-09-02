package com.zhang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-02 12:09
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain90 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain90.class, args);
    }
}
