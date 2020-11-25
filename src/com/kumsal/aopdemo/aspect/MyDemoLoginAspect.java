package com.kumsal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import jdk.nashorn.internal.objects.annotations.Setter;

@Aspect
@Component
public class MyDemoLoginAspect {

	@Pointcut("execution(* com.kumsal.aopdemo.doa.*.*( ..))")
	private void forDaoPacket(){
		
	}
	
	@Pointcut("execution(* com.kumsal.aopdemo.doa.*.get*( ..))")
	private void getter(){
		
	}
	
	@Pointcut("execution(* com.kumsal.aopdemo.doa.*.set*( ..))")
	private void setter(){
		
	}
	
	@Pointcut("forDaoPacket() && !(getter() || setter())")
	public void forDaoPackacgeNoSetterAndGetter(){
		
	}
	@Before("forDaoPackacgeNoSetterAndGetter()")
	public void beforeAddAccountAdvice(){
		System.out.println("=======> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackacgeNoSetterAndGetter()")
	public void performApiAnalitycs(){
		System.out.println("Performing api");
	}
	
	@Before("forDaoPackacgeNoSetterAndGetter()")
	public void logToCloudAsync(){
		System.out.println("logToCloudAsync");
	}
}
