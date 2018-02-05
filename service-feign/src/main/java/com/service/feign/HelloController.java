package com.service.feign;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private IHelloService helloService;

    @RequestMapping("sayHello")
    public String sayHello(@RequestParam("name") String name) {
        return helloService.sayHello(name);
    }
}
