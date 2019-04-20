package com.cloud.zipkin.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xiezhaokun
 */
@FeignClient(name="eureka-client")
public interface HelloFeign {
    @RequestMapping(value = "sayHello")
    String sayHello(@RequestParam("name") String name);
}
