package com.springdemo.camel.components.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoutesDemo2 extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		from("file://D:\\CamelDemo\\Folder1")
		.log("${body}")
		.to("file://D:\\CamelDemo\\Folder2");
	}
}

//for intercepting messages from any external url from(activemq:test-mq).log("log:receiving messages => ${body}");
