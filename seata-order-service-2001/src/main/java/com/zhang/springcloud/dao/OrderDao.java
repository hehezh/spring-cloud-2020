package com.zhang.springcloud.dao;

import com.zhang.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-10 18:27
 * @Version 1.0
 **/
@Mapper
public interface OrderDao {

    void create(Order order);

    void update(@Param("userId") Long userId, @Param("status") Integer status);

}
