package com.kumsal.springdemo;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {
	
	@Override
	public String getFortune() {
		
		return " Hello Today is your lucky day";
	}

	

}
