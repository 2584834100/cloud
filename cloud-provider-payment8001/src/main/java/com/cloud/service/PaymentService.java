package com.cloud.service;


import com.cloud.entity.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);

//    int createTransactional(Payment payment);
}
