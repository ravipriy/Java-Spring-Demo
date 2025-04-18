package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.services.PaymentServices;

public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/aop/config.xml");
		PaymentServices paymentObject = context.getBean("payment", PaymentServices.class);
		paymentObject.makePayment();
	}
}
