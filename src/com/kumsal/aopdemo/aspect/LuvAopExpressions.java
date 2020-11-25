package com.kumsal.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
public class LuvAopExpressions {
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
}
