package com.zhang.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author zhang
 * @Description 轮询负载均衡算法
 * @Date 2020-09-03 11:06
 * @Version 1.0
 **/
@Configuration
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current, next;
        do {
            current = this.atomicInteger.get();
            next = current > 2147483647 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*********访问次数next:" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
