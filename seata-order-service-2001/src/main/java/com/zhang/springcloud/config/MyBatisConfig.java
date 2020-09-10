package com.zhang.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-10 18:52
 * @Version 1.0
 **/
@Configuration
@MapperScan({"com.zhang.springcloud.dao"})
public class MyBatisConfig {
}
