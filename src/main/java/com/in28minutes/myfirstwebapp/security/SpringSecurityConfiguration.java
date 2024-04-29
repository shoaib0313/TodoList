package com.in28minutes.myfirstwebapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;


@Configuration
public class SpringSecurityConfiguration {
  // ldap or database
	//in memory
	
//	InMemoryUserDetailsManager
//	inMemoryUserDetailsManager(UserDetails...user user)
	
	@Bean
	public inMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails=User.withDefaultPasswordEncoder()
				.username("shoaib")
				.password("dummy")
				.roles("user","admin")
				.build();
		return new inMemoryUserDetailsManager();
	}
}
