package com.zhang.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author zhang
 * @Description spring配置
 * @Date 2020-09-01 13:35
 * @Version 1.0
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
//    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
