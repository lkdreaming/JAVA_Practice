package com.lk.spring.aop;

import org.springframework.stereotype.Component;


@Component
public class LogInterceptor {
	public void before() {
		System.out.println("before method");
	}
	
	public void after() {
		System.out.println("after method");
	}
}
