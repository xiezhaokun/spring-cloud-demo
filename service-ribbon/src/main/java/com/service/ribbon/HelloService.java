package com.service.ribbon;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHello(@RequestParam("name")String name) {
        return restTemplate.getForObject("http://eureka-client/sayHello?name="+name,String.class);
    }

    public String hiError(String name) {
        return "name="+name+",hi error!";

    }
}
