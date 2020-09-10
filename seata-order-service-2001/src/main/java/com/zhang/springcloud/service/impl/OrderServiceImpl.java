package com.zhang.springcloud.service.impl;

import com.zhang.springcloud.dao.OrderDao;
import com.zhang.springcloud.domain.Order;
import com.zhang.springcloud.service.AccountService;
import com.zhang.springcloud.service.OrderService;
import com.zhang.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-10 18:32
 * @Version 1.0
 **/
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @Override
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("-------->开始新建订单");
        orderDao.create(order);
        log.info("-------->订单微服务开始调用库存，做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------->订单微服务开始调用库存，做end");

        log.info("-------->订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------->订单微服务开始调用账户，做end");

        log.info("-------->修改订单状态开始");
        orderDao.update(order.getUserId(), 0);
        log.info("-------->修改订单状态结束，下单成功！");
    }


}
