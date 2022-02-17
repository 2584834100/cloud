package com.cloud.rabbitmq.topic;

import com.cloud.entity.Payment;
import com.cloud.util.JsonUtils;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "topics",type = "topic"),
                    key = {"user.*"}
            )
    })
    public void receive1(Payment payment) {
        System.out.println("message1" + JsonUtils.objectToJsonStr(payment));
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "topics",type = "topic"),
                    key = {"order.#", "produce.#","user.*"}
            )
    })
    public void receive2(Payment payment) {
        System.out.println("message2" + JsonUtils.objectToJsonStr(payment));
    }
}
