package com.service.feign;


import org.springframework.stereotype.Component;

@Component
public class HelloServiceHystrix implements IHelloService {
    @Override
    public String sayHello(String name) {
        return "name="+name+",error";
    }
}
