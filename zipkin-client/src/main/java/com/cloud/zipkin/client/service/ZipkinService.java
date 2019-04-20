package com.cloud.zipkin.client.service;

import com.cloud.zipkin.client.feign.HelloFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiezhaokun
 */
@Service
public class ZipkinService {

    @Autowired
    private HelloFeign helloFeign;

    public void doSomething(String name) {
        System.out.println("doSomething!");
        helloFeign.sayHello(name);
    }
}
