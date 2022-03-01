package com.cloud.services;


import org.springframework.stereotype.Component;

@Component
public class PaymentFeignFallbackService implements AlibabaPaymentFeignService{
    @Override
    public String getPort() {
        return "PaymentFeignFallbackService";
    }
}
