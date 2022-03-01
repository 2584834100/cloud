package com.cloud.config;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.common.CommonResult;

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4442, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }
}
