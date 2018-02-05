package com.eureka.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return "name="+name + ",port=" + port;
    }
}
