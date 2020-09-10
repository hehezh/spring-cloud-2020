package com.zhang.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.zhang.springcloud.dao"})
public class MyBatisConfig {
}
