package com.in28minutes.myfirstwebapp.loginAuthentticationService;

import org.springframework.stereotype.Service;

@Service
public class authenticationService {
	public boolean authenticate(String username,String password) {
		boolean isValidUsername=username.equalsIgnoreCase("shoaib");
		boolean isValidPassword=password.equalsIgnoreCase("shoaib");
		
		return isValidUsername && isValidPassword;
	}
 
}
