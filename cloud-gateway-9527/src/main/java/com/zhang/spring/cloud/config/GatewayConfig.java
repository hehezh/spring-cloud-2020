package com.zhang.spring.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-04 12:12
 * @Version 1.0
 **/
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator route = routes.route("path_route_zhang", r -> r.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route("path_route2_zhang", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return route;
    }

}
