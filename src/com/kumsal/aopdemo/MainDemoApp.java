package com.kumsal.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kumsal.aopdemo.doa.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext x=new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDao=x.getBean("accountDAO", AccountDAO.class);
		
		theAccountDao.addAccount();
		
		x.close();

	}

}
