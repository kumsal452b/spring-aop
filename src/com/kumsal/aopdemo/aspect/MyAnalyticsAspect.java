package com.kumsal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAnalyticsAspect {
	@Before("forDaoPackacgeNoSetterAndGetter()")
	public void performApiAnalitycs(){
		System.out.println("Performing api");
	}
	
}
