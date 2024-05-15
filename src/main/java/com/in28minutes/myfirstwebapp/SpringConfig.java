package com.in28minutes.myfirstwebapp;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.security.core.userdetails.User;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.security.provisioning.InMemoryUserDetailsManager;

	@Configuration
	public class SpringConfig {
		
			@Bean
			public PasswordEncoder passwordEncoder() {
				return new BCryptPasswordEncoder();
			}
			@Bean
			public UserDetailsService userDetailsService() {     // this interface provide by the spring boot to create the custom user
			UserDetails admin=User.builder()
					         .username("shoaib")
					         .password(passwordEncoder().encode("shoaib1"))
					         .roles("ADMIN")
					         .build();
			UserDetails user=User.builder()
			         .username(passwordEncoder().encode("shoaib1"))
			         .password("shoaib12")
			         .roles("USER")
			         .build();
			
			return new InMemoryUserDetailsManager(admin,user);
		}
			

	}
