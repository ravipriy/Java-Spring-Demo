package com.springdemo.camel.components.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


// this is basic example for producer ...... camel ....... consumer
//@Component
public class CamelRoutesDemo1 extends RouteBuilder {
	@Override
	public void configure() throws Exception {

		from("timer://test?period=5000") 			//Producer
		.setBody(simple("Hello Camel Bro..."))
		.to("log:t");							//Consumer
		
//		from("timer:bean-test-timer?period=5000")
//		.bean("myBean","myMethod1")			//.bean("beanName")   pass bean name here if it have multiple function then pass it name also
//											//.bean("beanName",functionName) 
//		.to("log:bean-test-timer");
	}
}

//@Component
class MyBean{
	public String myMethod1() {
		return "HIII from method 1";
	}
	
	public String myMethod2() {
		return "HIII from method 2";
	}
	
}
