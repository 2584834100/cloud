package com.cloud.services;

import com.cloud.common.CommonResult;
import com.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/getPort")
    public CommonResult getPort();

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment);
}
