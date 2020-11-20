package com.kumsal.aopdemo.doa;

import org.springframework.stereotype.Component;

@Component
public class MamberShipDAO {
	public String addAccount(){
		System.out.println(getClass()+" :DOING STUFF:");
		return "a";
	}
	public void goToSleep(){
		System.out.println("Goto sleep");
	}
}
