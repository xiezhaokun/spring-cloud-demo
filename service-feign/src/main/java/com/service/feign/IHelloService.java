package com.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="eureka-client" ,fallback =HelloServiceHystrix.class )
public interface IHelloService {

    @RequestMapping("sayHello")
    String sayHello(@RequestParam("name") String name);

}
