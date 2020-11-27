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
		theAccountDao.addAccount(myAccount,true);
		theAccountDao.doWork();
		theAccountDao.setName("foobar");
		theAccountDao.setServiceCode("silver");
		
		theMemberShipDAO.addAccount();
		theMemberShipDAO.addAccount();
		context.close();
		Scanner neScanner=new Scanner(System.in);
		
		Double value;
		value = neScanner.nextDouble();
		Double girilenDeger=0.0;
		int toplam=0;
		while (true) {
//			System.out.println(girilenDeger);
			System.out.println(toplam);
			girilenDeger=neScanner.nextDouble();
//			girilenDeger-=value;
			toplam+=girilenDeger;
		}
		
		
		

	}

}
