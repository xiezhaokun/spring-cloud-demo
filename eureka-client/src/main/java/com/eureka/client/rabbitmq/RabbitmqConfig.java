package com.eureka.client.rabbitmq;

import com.eureka.client.rabbitmq.model.ExchangeNames;
import com.eureka.client.rabbitmq.model.QueueNames;
import com.eureka.client.rabbitmq.model.RoutingKeys;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiezhaokun
 */
@Configuration
public class RabbitmqConfig {


    @Bean
    DirectExchange myDirectExchange() {
        return new DirectExchange(ExchangeNames.NORMAL_EXCHANGE,true,false);
    }

    @Bean
    Queue myQueue() {
        Map<String, Object> arguments = new HashMap<>(10);
        //过期后，消息从普通队列转移到死信交换机
        arguments.put("x-dead-letter-exchange",ExchangeNames.DEAD_EXCHANGE);
        //消息过期时间
        arguments.put("x-message-ttl",60000);
        //
        arguments.put("x-dead-letter-routing-key",RoutingKeys.DEAD_ROUTINGKEY);
        return new Queue(QueueNames.NORMAL_QUEUE, true, false, false, arguments);
    }

    @Bean
    Binding binding(Queue myQueue,DirectExchange myDirectExchange) {
        return BindingBuilder.bind(myQueue).to(myDirectExchange).with(RoutingKeys.NORMAL_ROUTINGKEY);
    }

    @Bean
    DirectExchange deadExchange() {
        return new DirectExchange(ExchangeNames.DEAD_EXCHANGE,true,false);
    }

    @Bean
    Queue deadQueue() {
        return new Queue(QueueNames.DEAD_QUEUE, true, false, false);
    }

    @Bean
    Binding bindingDead(Queue deadQueue,DirectExchange deadExchange) {
        return BindingBuilder.bind(deadQueue).to(deadExchange).with(RoutingKeys.DEAD_ROUTINGKEY);
    }


    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(ExchangeNames.HEADERS_EXCHANGE, true, false, null);
    }

    @Bean
    Queue headersQueue() {
        return new Queue(QueueNames.HEADERS_QUEUE, true, false, false, null);
    }


}
