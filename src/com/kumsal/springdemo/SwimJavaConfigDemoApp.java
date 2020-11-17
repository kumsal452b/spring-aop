package com.kumsal.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SwimJavaConfigDemoApp {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(SportConfig.class);

		Coach theCoach=context.getBean("swimCoach",Coach.class);
		SwimCoach sCoach=context.getBean("swimCoach",SwimCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(sCoach.getEmmai());
		System.out.println(sCoach.getTeam());
		context.close();
	}
}
