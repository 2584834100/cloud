package com.cloud.rabbitmq.direct;

import com.cloud.entity.Payment;
import com.cloud.util.JsonUtils;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DirectCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct"),//绑定交换机
                    key = {"info","error","warn"} // 路由key
            )
    })
    public void receive1(Payment payment) {
        System.out.println("message1" + JsonUtils.objectToJsonStr(payment));
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directs",type = "direct"),//绑定交换机
                    key = {"error"} // 路由key
            )
    })
    public void receive2(Payment payment) {
        System.out.println("message2" + JsonUtils.objectToJsonStr(payment));
    }
}
