package com.cts.sweb.sw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
	
	@RequestMapping({"","/","/home"})
//	public String defaultGetRequestHandler() {
//		return "home";  //action name is method name
//	}
	
	public ModelAndView defaultGetRequestHandler() {
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("home");
		
		mv.addObject("pageTitle","Home Page - Welcome All");
		mv.addObject("developers", new String[] {"pushpa","rekha","nandhu"});
		
		return mv;
	}

}
