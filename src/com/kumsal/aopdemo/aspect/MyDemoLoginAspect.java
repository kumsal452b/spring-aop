package com.kumsal.aopdemo.aspect;

import java.util.List;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.kumsal.aopdemo.Account;

import jdk.nashorn.internal.objects.annotations.Setter;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {
	
	@AfterReturning(pointcut="* com.kumsal.aopdemo.doa.findAccounts(..)",returning="result")
	public void afterReturningFindAccountService(
			Joinpoint thePoint,
			List<Account> result
			){
		
		
	}

	@Before("com.kumsal.aopdemo.aspect.LuvAopExpressions.forDaoPackacgeNoSetterAndGetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		System.out.println("=======> Executing @Before advice on addAccount()");
		MethodSignature theMethodSignature=(MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method :"+theMethodSignature);
		
		Object[] args=theJoinPoint.getArgs();
		
		for (Object object : args) {
			System.out.println(object);
			
			if (object instanceof Account) {
				Account theaccount=(Account) object;
				System.out.println("Account name :"+theaccount.getName());
				System.out.println("Account name :"+theaccount.getLevel());
			}
		}
	}
	

}
