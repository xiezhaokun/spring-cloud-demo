package com.cloud.demo.sleuth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author xiezhaokun
 */
@Service
public class SleuthService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void doSomeWorkSameSpan() throws InterruptedException {
        Thread.sleep(1000L);
        logger.info("Doing some work");
    }

    @Async
    public void asyncMethod() throws InterruptedException {
        logger.info("Start Async Method");
        Thread.sleep(1000L);
        logger.info("End Async Method");
    }
}
