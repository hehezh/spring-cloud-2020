package com.zhang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-03 11:04
 * @Version 1.0
 **/
public interface LoadBalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);



}
