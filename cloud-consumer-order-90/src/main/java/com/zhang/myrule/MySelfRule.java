package com.zhang.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-02 18:29
 * @Version 1.0
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }

}
