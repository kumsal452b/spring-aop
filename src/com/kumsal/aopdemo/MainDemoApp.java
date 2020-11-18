package com.kumsal.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kumsal.aopdemo.doa.AccountDAO;
import com.kumsal.aopdemo.doa.MamberShipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				   new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDao=context.getBean("accountDAO", AccountDAO.class);
		
		MamberShipDAO theMemberShipDAO=context.getBean("mamberShipDAO",MamberShipDAO.class);
		
		theAccountDao.addAccount();
		
		theMemberShipDAO.addAccount();
		context.close();

	}

}
