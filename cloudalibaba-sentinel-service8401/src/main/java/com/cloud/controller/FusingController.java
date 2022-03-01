package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.services.AlibabaPaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FusingController {

    @Resource
    private AlibabaPaymentFeignService alibabaPaymentFeignService;

    @GetMapping("/getPort")
//    @SentinelResource(value = "getPort",fallback = "handlerFallback")// fallback只负责业务异常
//    @SentinelResource(value = "getPort", blockHandler = "blockHandler") //blockHandler只负责sentinel控制台配置违规(流控、降级等返回)
//    @SentinelResource(value = "getPort",
//            fallback = "handlerFallback",
//            blockHandler = "blockHandler")// 同时生效 blockHandler优先级高于fallback
//    @SentinelResource(value = "getPort", exceptionsToIgnore = {Exception.class, RuntimeException.class})// exceptionsToIgnore：使fallback忽略此异常
    public String getPort() {
        return alibabaPaymentFeignService.getPort();
    }

    public String handlerFallback(Throwable e) {
        return "getPort发送异常:" + e.getMessage();
    }

    public String blockHandler(BlockException exception) {
        return "getPort不可用:" + exception.getClass().getCanonicalName();
    }
}
