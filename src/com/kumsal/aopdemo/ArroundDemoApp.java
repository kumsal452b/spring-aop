package com.kumsal.aopdemo;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kumsal.aopdemo.doa.AccountDAO;
import com.kumsal.aopdemo.doa.MamberShipDAO;
import com.kumsal.aopdemo.service.TrafficFortuneService;

public class ArroundDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = 
				   new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		TrafficFortuneService thTrafficFortuneService=context.getBean("accountDAO", TrafficFortuneService.class);
		
		context.close();
	}

}
