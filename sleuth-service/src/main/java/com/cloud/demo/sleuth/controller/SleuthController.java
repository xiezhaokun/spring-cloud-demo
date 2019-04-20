package com.cloud.demo.sleuth.controller;

import com.cloud.demo.sleuth.service.SleuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiezhaokun
 */
@RestController
public class SleuthController {

    private static final Logger logger = LoggerFactory.getLogger(SleuthController.class);

    @Resource
    private SleuthService sleuthService;

    @GetMapping(value = "/some-span")
    public String doSomeWorkSameSpan() throws InterruptedException {
        sleuthService.doSomeWorkSameSpan();
        return "success";
    }

    @GetMapping("/async")
    public String helloSleuthAsync() throws InterruptedException {
        logger.info("Before Async Method Call");
        sleuthService.asyncMethod();
        logger.info("After Async Method Call");
        return "success";
    }

}
