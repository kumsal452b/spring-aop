package com.kumsal.aopdemo;

import java.util.List;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kumsal.aopdemo.doa.AccountDAO;
import com.kumsal.aopdemo.doa.MamberShipDAO;
import com.kumsal.aopdemo.service.TrafficFortuneService;

public class ArroundDemoApp {

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = 
				   new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		TrafficFortuneService thTrafficFortuneService=context.getBean("trafficFortuneService", TrafficFortuneService.class);
		System.out.println("Main demo app");
		System.out.println("Calling fortune...");
		String Name="Yahya     Alatas";
//		Name=Name.replaceAll("\\s+","");
		System.out.println(Name);
		String name="";
		String surname="";
		int 
		System.out.println(name+" "+surname);
		String data=thTrafficFortuneService.getFortune();
		System.out.println("My fortne is :"+data);
		System.out.println("Finished");
		context.close();
	}

}
