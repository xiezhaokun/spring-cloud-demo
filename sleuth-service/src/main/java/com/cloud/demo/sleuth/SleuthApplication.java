package com.cloud.demo.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 日志的格式为：[application name, traceId, spanId, export]

 application name — 应用的名称，也就是application.properties中的spring.application.name参数配置的属性。

 traceId — 为一个请求分配的ID号，用来标识一条请求链路。

 spanId — 表示一个基本的工作单元，一个请求可以包含多个步骤，每个步骤都拥有自己的spanId。一个请求包含一个TraceId，多个SpanId

 export — 布尔类型。表示是否要将该信息输出到类似Zipkin这样的聚合器进行收集和展示。

 可以看到，TraceId和SpanId在两条日志中是相同的，即使消息来源于两个不同的类。这就可以在不同的日志通过寻找traceid来识别一个请求。

 */
@SpringBootApplication
public class SleuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SleuthApplication.class, args);
	}

}
