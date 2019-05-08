package com.eureka.client.rabbitmq.service;

import com.eureka.client.rabbitmq.model.QueueNames;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xiezhaokun
 * @description
 * @date 2018/9/12 下午3:29
 */
@Component
public class MessageConsumerService {

    @RabbitListener(queues = QueueNames.DEAD_QUEUE)
    public void onMessage(Message message) {
        System.out.println("receive message : " + message.getBody().toString());
    }

    @RabbitListener(queues = QueueNames.HEADERS_QUEUE)
    public void consumeHeaderMessage(Message message) {
        System.out.println("receive message : " + message.getBody().toString());
    }
}
