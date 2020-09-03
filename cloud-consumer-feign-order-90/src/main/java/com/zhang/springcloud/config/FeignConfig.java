package com.zhang.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-03 14:01
 * @Version 1.0
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
