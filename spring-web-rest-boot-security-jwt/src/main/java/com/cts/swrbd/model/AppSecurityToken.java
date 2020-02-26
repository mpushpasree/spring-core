package com.cts.swrbd.model;

import java.io.Serializable;

public class AppSecurityToken implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private final String jwttoken;   //FINAL: for the first time value is assigned after that it becomes constant.
	
	public String getJwttoken() {
		return this.jwttoken;
	}

	public AppSecurityToken(String jwttoken) {
		
		this.jwttoken = jwttoken;
	}
}
