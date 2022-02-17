package com.cloud;

import com.cloud.entity.Payment;
import com.cloud.service.PaymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = PaymentMain8001.class)
@RunWith(SpringRunner.class)
public class TestTransactional {

    @Autowired
    private PaymentService paymentService;

    @Test
    public void test() {
        Payment payment = new Payment();
        payment.setSerial("TestTransactional-4");
        paymentService.create(payment);
    }
}
