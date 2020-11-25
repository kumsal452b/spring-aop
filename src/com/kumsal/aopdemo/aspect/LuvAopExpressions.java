package com.kumsal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvAopExpressions {
	@Pointcut("execution(* com.kumsal.aopdemo.doa.*.*( ..))")
	public void forDaoPacket(){
		
	}
	
	@Pointcut("execution(* com.kumsal.aopdemo.doa.*.get*( ..))")
	public void getter(){
		
	}
	
	@Pointcut("execution(* com.kumsal.aopdemo.doa.*.set*( ..))")
	public void setter(){
		
	}
	
	@Pointcut("forDaoPacket() && !(getter() || setter())")
	public void forDaoPackacgeNoSetterAndGetter(){
		
	}
}
