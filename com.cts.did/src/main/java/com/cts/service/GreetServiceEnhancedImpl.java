package com.cts.service;

public class GreetServiceEnhancedImpl implements GreetService{
	private String greeting;
	public String getGreeting() {
		return greeting+" "+"userName";
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public GreetServiceEnhancedImpl() {
		super();
	}
	public String greet(String userName) {
		
		return greeting+" "+userName;
	}
	public GreetServiceEnhancedImpl(String greeting) {
		super();
		this.greeting = greeting;
	}

}
