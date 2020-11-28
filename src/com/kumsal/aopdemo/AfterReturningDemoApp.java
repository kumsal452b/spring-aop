package com.kumsal.aopdemo;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kumsal.aopdemo.doa.AccountDAO;
import com.kumsal.aopdemo.doa.MamberShipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				   new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDao=context.getBean("accountDAO", AccountDAO.class);
		List<Account> theAccounts=theAccountDao.findAcounts();
		
		
		context.close();
	}

}
