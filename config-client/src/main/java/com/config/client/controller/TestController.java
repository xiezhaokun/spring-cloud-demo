package com.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiezhaokun
 */
@RestController
@RefreshScope
@RequestMapping(value = "/say")
public class TestController {

    @Value("${my.name}")
    private String myName;

    @RequestMapping(value = "/hello")
    public Object hello() {
        return "hello :" + myName;
    }
}
