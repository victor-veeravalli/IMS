package com.inventory.management.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ServiceAuthorizationConfig extends WebSecurityConfigurerAdapter {

	/*
	 * @Autowired public void configureGlobal(AuthenticationManagerBuilder
	 * authenticationMgr) throws Exception {
	 * 
	 * User.UserBuilder users = User.withDefaultPasswordEncoder();
	 * InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	 * manager.createUser(users.username("user").password("user@123").roles("USER").
	 * build());
	 * manager.createUser(users.username("admin").password("admin@123").roles(
	 * "USER", "ADMIN").build());
	 * 
	 * }
	 */
	
	  @Bean
	  public UserDetailsService userDetailsService() {
	  
	  User.UserBuilder users = User.withDefaultPasswordEncoder();
	  InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	  manager.createUser(users.username("user").password("user@123").roles(
	  "USER").build());
	  manager.createUser(users.username("admin").password("admin@123").roles(
	  "USER", "ADMIN").build()); return manager;
	  
	  }
	 

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// PasswordEncoder encoder =
		// PasswordEncoderFactories.createDelegatingPasswordEncoder();
		/*
		 * http.authorizeRequests().antMatchers("/getUsers").hasAnyAuthority("USER",
		 * "ADMIN").antMatchers("/getUserbyId") .hasAnyAuthority("USER",
		 * "ADMIN").antMatchers("/deleteUserbyId").hasAuthority("ADMIN").anyRequest()
		 * .authenticated().and().formLogin().permitAll().and().logout().permitAll().and
		 * ().exceptionHandling() .accessDeniedPage("/403")
		 * .and().csrf().disable().headers().frameOptions().disable();
		 */

		http.authorizeRequests().antMatchers("/users/deleteUserbyId").hasRole("ADMIN")
		.antMatchers("/users/getUserbyId").hasAnyRole("ADMIN","USER")
		.antMatchers("/users/createUser").hasAnyRole("ADMIN","USER")
		.antMatchers("/users/getUsers").permitAll()
		.and().formLogin().and().exceptionHandling()
		.accessDeniedPage("/403") .and().csrf().disable().headers().frameOptions().disable();
	
	}

}
