package com.kumsal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

	@Pointcut("execution(* com.kumsal.aopdemo.doa.*.*( ..))")
	private void forDaoPacket(){
		
	}
	
	@Before("forDaoPacket()")
	public void beforeAddAccountAdvice(){
		System.out.println("=======> Executing @Before advice on addAccount()");
	}
}
