package com.cloud.controller;

import com.cloud.common.CommonResult;
import com.cloud.entity.Payment;
import com.cloud.services.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/getPort")
    public CommonResult getPort(){
        return paymentFeignService.getPort();
    }

    @PostMapping("/consumer/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        return paymentFeignService.create(payment);
    }

    @GetMapping(value = "/globalReturnConfig")
    public Payment globalReturnConfig() {
        return new Payment();
    }
}
