package com.cloud.rabbitmq.fanout;

import com.cloud.entity.Payment;
import com.cloud.util.JsonUtils;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanoutCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(autoDelete = "true"),//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")//绑定交换机
            )
    })
    public void receive1(Payment payment) {
        System.out.println("message1" + JsonUtils.objectToJsonStr(payment));
    }
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(autoDelete = "true"),//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")//绑定交换机
            )
    })
    public void receive2(Payment payment) {
        System.out.println("message2" + JsonUtils.objectToJsonStr(payment));
    }
}
