package com.kumsal.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.context.Theme;

import com.kumsal.aopdemo.Account;

import jdk.nashorn.internal.objects.annotations.Setter;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {
	
	@Aspect("execution(* com.kumsal.aopdemo.doa.AccountDAO.findAcounts(..))")
	public void afterFinalyFindAccountAdvice(JoinPoint jPoint){
		
	}
	
	@AfterThrowing(
			pointcut="execution(* com.kumsal.aopdemo.doa.AccountDAO.findAcounts(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint  theJp,Throwable theExc){
		String method=theJp.getSignature().toShortString();
		
		System.out.println("method =====> executing afterThrowing run method "+method);
		
		System.out.println("method =====> The expcetion:  "+theExc);
		
	}
	
	@AfterReturning(pointcut="execution(* com.kumsal.aopdemo.doa.AccountDAO.findAcounts(..))",returning="result")
	public void afterReturningFindAccountService(
			JoinPoint thePoint,
			List<Account> result
			){
		String method=thePoint.getSignature().toShortString();
		
		System.out.println("method =====> executing after run method "+method);
		
		System.out.println("Result is===> " +result);
		
		convertAccountNamesToUpperCase(result);
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {
		for (Account account : result) {
			String upperName=account.getName().toUpperCase();
			
			account.setName(upperName);
		}
		
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
