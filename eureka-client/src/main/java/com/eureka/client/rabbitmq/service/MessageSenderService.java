package com.eureka.client.rabbitmq.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author xiezhaokun
 * @description 消息发送者
 * @date 2018/9/12 下午2:48
 */
@Component
public class MessageSenderService {

    private static final Logger logger = LoggerFactory.getLogger(MessageSenderService.class);

    @Resource
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     * @param exchange 交换机
     * @param routingKey 路由键
     * @param message 消息
     */
    public void sendMessage(final String exchange,final String routingKey, final String message) {
        logger.info("== begin sendMessage : " + message + " ==");
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        logger.info("== end sendMessage : " + message + " ==");
    }

    public void sendHeaderMessage(final String exchange,final String msg) {
        rabbitTemplate.convertAndSend(exchange,null, java.util.Optional.ofNullable(msg).get(), new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().getHeaders().put("name","xiezk");
                return message;
            }
        });
    }

}
