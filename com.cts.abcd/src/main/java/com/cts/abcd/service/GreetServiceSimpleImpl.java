package com.cts.abcd.service;

import org.springframework.stereotype.Component;

@Component("g1")
public class GreetServiceSimpleImpl implements GreetService{

	public String greet(String userName) {
		
		return "Hello "+userName;
	}
	

}
