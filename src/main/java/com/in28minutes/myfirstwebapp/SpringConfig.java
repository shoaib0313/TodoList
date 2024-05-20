package com.in28minutes.myfirstwebapp;

	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
	import org.springframework.security.core.userdetails.UserDetails;
	import org.springframework.security.core.userdetails.UserDetailsService;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.security.crypto.password.PasswordEncoder;
	import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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
					         .password(passwordEncoder().encode("shoaib"))
					         .roles("ADMIN")
					         .build();
			UserDetails user=User.builder()
			         .username(passwordEncoder().encode("shoaib12"))
			         .password("shoaib12")
			         .roles("USER")
			         .build();
			
			return new InMemoryUserDetailsManager(admin,user);
		}
			
			@Bean
			public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
				return security
					.authorizeHttpRequests(auth->auth
							.requestMatchers("/welcome").permitAll()
							.requestMatchers("/listTodos/**").hasAnyRole("ADMIN")
							.requestMatchers("/todos").hasAnyRole("USER").anyRequest().
							authenticated()).formLogin(form->form.permitAll())
					.build();	
			}
			

	}
