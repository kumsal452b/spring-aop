package com.kumsal.aopdemo.service;

import java.util.concurrent.TimeUnit;

public class TrafficFortuneService {

	public String getFortune() throws InterruptedException{
		TimeUnit.SECONDS.sleep(5);
	
		
		return "Expect heavy this morning";
	}
}
