package com.Mettles.RCClient;

import javax.ws.rs.FormParam;

public class RCFormData {
	
	private String email;
	private String name;
	
	public RCFormData() {
	//default constructor
	}
	
	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}
	
	@FormParam("email")
	public void setEmail(String email) {
		this.email = email;
	}
	
	@FormParam("name")
	public void setName(String name) {
		this.name = name;
	}
}
