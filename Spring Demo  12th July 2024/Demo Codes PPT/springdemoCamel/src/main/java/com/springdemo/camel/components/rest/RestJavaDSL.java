package com.springdemo.camel.components.rest;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RestJavaDSL extends RouteBuilder {
	
	@Override
	public void configure() throws Exception{
//		from("rest:get:getdata{city}?produce=application/json").process(this.getMyData);
		
	}
	private void getMyData(Exchange ex) {
//		ex.getMessage().getHeader("city",String.class)
		
	}

}
