package com.cloud;

import com.cloud.entity.Payment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = OrderMain80.class)
@RunWith(SpringRunner.class)
public class TestRabbitMQ {

    //注入RabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // topic 动态路由   发布、订阅模式
    @Test
    public void testTopic() {
        Payment payment = new Payment();
        String key = "user.service";
        payment.setSerial(key);
        rabbitTemplate.convertAndSend("topics",key,payment);
    }

    // route 路由模式
    @Test
    public void testRoute() {
        Payment payment = new Payment();
        payment.setSerial("route");
        rabbitTemplate.convertAndSend("directs", "error",payment);
    }

    // fanout 广播模式
    @Test
    public void testFanout() {
        Payment payment = new Payment();
        payment.setSerial("fanout");
        // exchange 交换机名
        // 使用交换机，让交换机创建临时队列，此模式不需要路由(routingKey)
        rabbitTemplate.convertAndSend("logs", "", payment);
    }

    // work
    @Test
    public void testWork() {
        for (int i = 0; i < 10; i++) {
            Payment payment = new Payment();
            payment.setSerial("work-" + i);
            // routingKey：路由key，无交换机的模式下主要作为队列名
            rabbitTemplate.convertAndSend("work", payment);
        }
    }

    // hello word
    @Test
    public void test() {

        Payment payment = new Payment();
        payment.setSerial("hello word");
        // routingKey：路由key，无交换机的模式下主要作为队列名
        rabbitTemplate.convertAndSend("hello", payment);
    }
}
