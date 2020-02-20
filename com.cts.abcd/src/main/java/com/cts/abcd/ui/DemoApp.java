package com.cts.abcd.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cts.abcd.config.AbcdConfig;
import com.cts.abcd.service.GreetService;
import com.cts.abcd.service.GreetServiceAdvancedImpl;

public class DemoApp {

	public static void main(String[] args) {
		
		//java based config
		
		ApplicationContext context=new AnnotationConfigApplicationContext(AbcdConfig.class);
		System.out.println(context.getBean("today"));
		
		GreetService gs1=(GreetService)context.getBean("g1");
		System.out.println(gs1.greet("nanna"));
		
		GreetService gs2=(GreetService)context.getBean("g2");
		System.out.println(gs2.greet("amma"));
		
		
		
		
	}

}
