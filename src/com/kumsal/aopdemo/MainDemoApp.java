package com.kumsal.aopdemo;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kumsal.aopdemo.doa.AccountDAO;
import com.kumsal.aopdemo.doa.MamberShipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				   new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO theAccountDao=context.getBean("accountDAO", AccountDAO.class);
		
		MamberShipDAO theMemberShipDAO=context.getBean("mamberShipDAO",MamberShipDAO.class);
		Account myAccount=new Account();
		
		myAccount.setName("Kumsal");
		myAccount.setLevel("Platinium");
		
		theAccountDao.addAccount(myAccount,true);
		theAccountDao.doWork();
		theAccountDao.setName("foobar");
		theAccountDao.setServiceCode("silver");
		
		theMemberShipDAO.addAccount();
		theMemberShipDAO.addAccount();
		context.close();
	}

}
