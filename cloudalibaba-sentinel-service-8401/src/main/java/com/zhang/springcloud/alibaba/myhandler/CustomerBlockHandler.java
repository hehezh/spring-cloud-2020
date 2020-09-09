package com.zhang.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zhang.springcloud.entities.CommonResult;

/**
 * @Author zhang
 * @Description //整条街最靓的仔，写点注释吧
 * @Date 2020-09-09 18:49
 * @Version 1.0
 **/
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException e) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException e) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}
