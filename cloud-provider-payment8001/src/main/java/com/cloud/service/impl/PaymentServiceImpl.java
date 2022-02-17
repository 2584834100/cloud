package com.cloud.service.impl;

import com.cloud.dao.PaymentDao;
import com.cloud.entity.Payment;
import com.cloud.service.PaymentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Resource
    private PaymentService paymentService;

//    @Override
//    public int create(Payment payment) {
//        return paymentService.createTransactional(payment);
//    }
//
//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public int createTransactional(Payment payment){
//        int i = paymentDao.create(payment);
//        int a = 1/0;
//        return i;
//    }

    @Override
    @Transactional(rollbackFor = Exception.class)// 生效！！
    public int create(Payment payment) {
        int middle = middle(payment);
        return middle;
    }

//    @Transactional(rollbackFor = Exception.class)// 不生效！
    public int middle(Payment payment) {
        return createTransactional(payment);
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)// 不生效！
    public int createTransactional(Payment payment){
        int i = paymentDao.create(payment);
        int a = 1/0;
        return i;
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
