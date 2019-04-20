package com.cloud.zipkin.client.controller;

import com.cloud.zipkin.client.service.ZipkinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author xiezhaokun
 */
@RestController
public class ZipkinController {

    @Resource
    private ZipkinService zipkinService;

    @GetMapping(value = "/doSomething")
    public String doSomething(@RequestParam("name") String name) {
        zipkinService.doSomething(name);
        return "success";
    }

}
