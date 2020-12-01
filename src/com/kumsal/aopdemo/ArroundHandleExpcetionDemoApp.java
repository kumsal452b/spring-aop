package com.kumsal.aopdemo;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.swing.text.AbstractDocument.BranchElement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kumsal.aopdemo.doa.AccountDAO;
import com.kumsal.aopdemo.doa.MamberShipDAO;
import com.kumsal.aopdemo.service.TrafficFortuneService;

public class ArroundHandleExpcetionDemoApp {


	private static Logger myLogger=Logger.getLogger(ArroundHandleExpcetionDemoApp.class.getName());
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = 
				   new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		TrafficFortuneService thTrafficFortuneService=context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("Main demo app");
		myLogger.info("Calling fortune...");

		String data=thTrafficFortuneService.getFortune();
		myLogger.info("My fortne is :"+data);
		myLogger.info("Finished");
		context.close();
	}

}
