package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("configureGlobalSecurity");
		/*auth.inMemoryAuthentication().withUser("principal").password("principal").roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("teacher").password("teacher").roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("parjanya").password("roy").roles("USER","ADMIN");*/
		
		auth.inMemoryAuthentication().withUser("principal").password("principal").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("teacher").password("teacher").roles("ADMIN");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("configure");
		/*http.authorizeRequests().antMatchers("/", "/listCustomers").permitAll()
		.antMatchers("/register**","/editCustomerData**").access("hasRole('USER')")
		.antMatchers("/deleteCustomerData**").access("hasRole('ADMIN') and hasRole('DBA')")
		.and().formLogin().loginPage("/login").usernameParameter("username").passwordParameter("password").and().exceptionHandling().accessDeniedPage("/Access_Denied");*/
		
		
		http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("/", "/welcome","/register**","/list*").access("hasRole('USER') or hasRole('ADMIN')")
		.and().formLogin().loginPage("/login")
		.usernameParameter("username").passwordParameter("password").and()
		.exceptionHandling().accessDeniedPage("/Access_Denied");

	}

	/**
	 * 
	 * The first and foremost step to add spring security in our application is
	 * to create Spring Security Java Configuration. This configuration creates
	 * a Servlet Filter known as the springSecurityFilterChain which is
	 * responsible for all the security (protecting the application URLs,
	 * validating submitted username and passwords, redirecting to the log in
	 * form, etc) within our application.
	 *
	 * Method configureGlobalSecurity in above class configures
	 * AuthenticationManagerBuilder with user credentials and allowed roles.
	 * This AuthenticationManagerBuilder creates AuthenticationManager which is
	 * responsible for processing any authentication request. Notice that in
	 * above example, we have used in-memory authentication while you are free
	 * to choose from JDBC, LDAP and other authentications.
	 * 
	 * The overridden Method Configure configures HttpSecurity which allows
	 * configuring web based security for specific http requests. By default it
	 * will be applied to all requests, but can be restricted using
	 * requestMatcher(RequestMatcher)/antMathchers or other similar methods.
	 * 
	 * In above configuration, we say that URL’s ‘/’ & ‘/home’ are not secured,
	 * anyone can access them. URL ‘/admin/**’ can only be accessed by someone
	 * who have ADMIN role. URL ‘/db/**’ can only be accessed by someone who
	 * have both ADMIN and DBA roles.
	 * 
	 * Method formLogin provides support for form based authentication and will
	 * generate a default form asking for user credentials. You are allowed to
	 * configure your own login form.We will see examples for the same in
	 * subsequent posts. We have also used
	 * exceptionHandling().accessDeniedPage() which in this case will catch all
	 * 403 [http access denied] exceptions and display our user defined page
	 * instead of showing default HTTP 403 page [ which is not so helpful
	 * anyway].
	 */

}
