package com.cts.abcd.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.cts.abcd.service")
public class AbcdConfig {
	
	@Bean
	public LocalDate today() {
		return LocalDate.now();
	}

}
