package com.kumsal.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.ui.context.Theme;

import com.kumsal.aopdemo.Account;

import jdk.nashorn.internal.objects.annotations.Setter;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {
	
	private Logger myLogger=Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.kumsal.aopdemo.service.*.getFortune(..))")
	public Object arroundGetFortune(ProceedingJoinPoint theProccedingJoinPoint) throws Throwable{
		
		String method=theProccedingJoinPoint.getSignature().toShortString();
		
		myLogger.info("method =====> executing Around run method "+method);
		long begin=System.currentTimeMillis();
		
		Object result=theProccedingJoinPoint.proceed();
		
		long end=System.currentTimeMillis();
		
		long duration=end-begin;
		
		myLogger.info("======? "+duration/1000.0+" seccond");
		
		return result;
		
	}
	
	@After("execution(* com.kumsal.aopdemo.doa.AccountDAO.findAcounts(..))")
	public void afterFinalyFindAccountAdvice(JoinPoint jPoint){
		String method=jPoint.getSignature().toShortString();
		
		myLogger.info("method =====> executing after finaly run method "+method);
	}
	
	@AfterThrowing(
			pointcut="execution(* com.kumsal.aopdemo.doa.AccountDAO.findAcounts(..))",
			throwing="theExc"
			)
	public void afterThrowingFindAccountAdvice(JoinPoint  theJp,Throwable theExc){
		String method=theJp.getSignature().toShortString();
		
		myLogger.info("method =====> executing afterThrowing run method "+method);
		
		myLogger.info("method =====> The expcetion:  "+theExc);
		
	}
	
	@AfterReturning(pointcut="execution(* com.kumsal.aopdemo.doa.AccountDAO.findAcounts(..))",returning="result")
	public void afterReturningFindAccountService(
			JoinPoint thePoint,
			List<Account> result
			){
		String method=thePoint.getSignature().toShortString();
		
		myLogger.info("method =====> executing after run method "+method);
		
		myLogger.info("Result is===> " +result);
		
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
		myLogger.info("=======> Executing @Before advice on addAccount()");
		MethodSignature theMethodSignature=(MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method :"+theMethodSignature);
		
		Object[] args=theJoinPoint.getArgs();
		
		for (Object object : args) {
			myLogger.info((String) object);
			
			if (object instanceof Account) {
				Account theaccount=(Account) object;
				myLogger.info("Account name :"+theaccount.getName());
				myLogger.info("Account name :"+theaccount.getLevel());
			}
		}
		
	}
	

}
