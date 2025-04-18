package com.aop.services;

public class PaymentServiceImplementation implements PaymentServices {
	@Override
	public void makePayment() {
		System.out.println("*********** Payment Process Start ************");
		System.out.println("Making Payment...");
		System.out.println("Payment Completed...");
		System.out.println("*********** Payment Process End ************");
	}
}
