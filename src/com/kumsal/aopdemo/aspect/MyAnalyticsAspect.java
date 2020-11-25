package com.kumsal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAnalyticsAspect {
	@Before("com.kumsal.aopdemo.aspect.LuvAopExpressions.forDaoPackacgeNoSetterAndGetter()")
	public void performApiAnalitycs(){
		System.out.println("Performing api");
	}
	
}
