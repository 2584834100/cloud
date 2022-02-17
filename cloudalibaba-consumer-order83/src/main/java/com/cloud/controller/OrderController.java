package com.cloud.controller;

import com.cloud.services.NacosPaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private NacosPaymentFeignService nacosPaymentFeignService;

    @GetMapping("/getPort")
    public String getPort() {
        return nacosPaymentFeignService.getPort();
    }
}
