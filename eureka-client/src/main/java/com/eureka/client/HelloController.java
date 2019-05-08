package com.eureka.client;


import com.eureka.client.rabbitmq.model.ExchangeNames;
import com.eureka.client.rabbitmq.model.RoutingKeys;
import com.eureka.client.rabbitmq.service.MessageSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @Resource
    private MessageSenderService messageSenderService;

    @RequestMapping("sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return "name="+name + ",port=" + port;
    }

    @RequestMapping("sendMessage")
    public Object send() {
        messageSenderService.sendMessage(ExchangeNames.NORMAL_EXCHANGE, RoutingKeys.NORMAL_ROUTINGKEY,"测试死信队列！！！！！");
        return "success";
    }


    @RequestMapping("sendHeaderMessage")
    public Object sendHeaderMessage() {
        messageSenderService.sendHeaderMessage(ExchangeNames.HEADERS_EXCHANGE, "测试headersExchange！！！！！");
        return "success";
    }
}
