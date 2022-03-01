package com.cloud.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "cloud-alibaba-provider", fallback = PaymentFeignFallbackService.class)
public interface AlibabaPaymentFeignService {

    @GetMapping("/getPort")
    public String getPort();
}
