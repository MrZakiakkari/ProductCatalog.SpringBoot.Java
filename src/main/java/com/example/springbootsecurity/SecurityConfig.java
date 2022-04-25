package com.example.springbootsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception
	{
		PasswordEncoder encoder
				= PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication()
				.withUser("mary")
				.password(encoder.encode("pass"))
				.roles("User")
				.and()
				.withUser("tom")
				.password(encoder.encode("pass"))
				.roles("Admin")
				.and()
				.withUser("bob")
				.password(encoder.encode("pass"))
				.roles("SuperAdmin");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests()
				.antMatchers("/add-product/**").access("hasRole('SuperAdmin')")
				.antMatchers("/edit-product/**").access("hasAnyRole('Admin', 'SuperAdmin')")
				.antMatchers("/delete-product/**").access("hasAnyRole('Admin', 'SuperAdmin')")
				.and()
				.formLogin()//	This is the line that generates a login page
				;
	}
}
