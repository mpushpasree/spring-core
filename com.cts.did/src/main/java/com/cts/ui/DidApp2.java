package com.cts.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.service.GreetService;
import com.cts.service.GreetServiceEnhancedImpl;

public class DidApp2 {

	//DEFAULT SCOPE IS "SINGLETON"
	
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans2.xml");
		
		GreetServiceEnhancedImpl gs2=(GreetServiceEnhancedImpl) context.getBean("g2");
		System.out.println(gs2.greet("pushpa"));
		gs2.setGreeting("Vanakkam");
		System.out.println(gs2.greet("pushpa"));
		
		GreetServiceEnhancedImpl gs3=(GreetServiceEnhancedImpl) context.getBean("g2");
		System.out.println(gs3.greet("pushpa"));
		

		GreetService gs=(GreetService)context.getBean("g3");
		System.out.println(gs.greet("nanna"));
		
		
		
	}

}
