package com.cloud.demo.sleuth.config;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.cloud.sleuth.instrument.async.LazyTraceExecutor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * @author xiezhaokun
 */
@Configuration
@EnableAsync
public class ThreadConfig extends AsyncConfigurerSupport{

    @Resource
    private BeanFactory beanFactory;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(7);
        threadPoolTaskExecutor.setMaxPoolSize(42);
        threadPoolTaskExecutor.setQueueCapacity(11);
        threadPoolTaskExecutor.setThreadNamePrefix("MyExecutor-");
        threadPoolTaskExecutor.initialize();
        return new LazyTraceExecutor(beanFactory, threadPoolTaskExecutor);
    }
}
