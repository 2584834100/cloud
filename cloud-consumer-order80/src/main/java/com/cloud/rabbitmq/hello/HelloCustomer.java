package com.cloud.rabbitmq.hello;

//@Component
//// 默认 持久化  非独占  不是自动删除
//@RabbitListener(queuesToDeclare = @Queue(value = "hello", declare = "true"/*是否持久化队列*/, autoDelete = "true"/*是否自动删除*/))
public class HelloCustomer {

//    @RabbitHandler
//    public void receive1(Payment payment) {
//        System.out.println(JsonUtils.objectToJsonStr(payment));
//    }
}
