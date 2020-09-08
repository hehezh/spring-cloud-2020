package com.zhang.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-08 14:10
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosClient3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosClient3377.class, args);
    }

}
