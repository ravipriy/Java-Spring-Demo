package com.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
	
	//if makePayment() is accepting any parameters then we have 2 give pattern for this.
	//@Before("execution(* com.aop.services.PaymentServiceImplementation.makePayment(..))")
	@Before("execution(* com.aop.services.PaymentServiceImplementation.makePayment())")
	public void printBefore232() {
		System.out.println("Please wait we are checking your credentials...");
		System.out.println("Now Authenticating...");
	}
	
	@After("execution(* com.aop.services.PaymentServiceImplementation.makePayment())")
	public void printAfter111() {
		System.out.println("Going out everything is completed...");
	}

}
