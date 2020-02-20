package com.cts.service;

public class GreetServiceSimpleImpl implements GreetService{

	public String greet(String userName) {
		
		return "Hello "+userName;
	}
	

}
