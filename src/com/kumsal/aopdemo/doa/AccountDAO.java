package com.kumsal.aopdemo.doa;

import org.springframework.stereotype.Component;

import com.kumsal.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount,boolean vipFlag){
		
		System.out.println(getClass()+" :DOING MY DB WORK: ADDING AN ACCOUNT");
		
	}
	public boolean doWork(){
		System.out.println(getClass()+" :doing work");
		return false;
	}
	public String getName() {
		System.out.println(getClass()+" : getname doing work");
		return name;
	}
	public void setName(String name) {
		System.out.println(getClass()+" :setname doing work");
		this.name = name;
	}
	public String getServiceCode() {
		System.out.println(getClass()+" getservice gt:doing work");
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
		System.out.println(getClass()+" setservice gt:doing work");
	}
	
}
