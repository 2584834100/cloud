package com.cloud.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("nacos-payment-provider")
public interface NacosPaymentFeignService {

    @GetMapping("/getPort")
    public String getPort();
}
