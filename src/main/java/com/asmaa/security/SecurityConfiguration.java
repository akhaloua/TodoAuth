package com.asmaa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.asmaa.todo.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;
		public void setUserDetailsService(UserDetailsServiceImpl userDetailsService) {
	    this.userDetailsService = userDetailsService;
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder authentication) throws Exception {
	   // authentication.userDetailsService(userDetailsService);
	    authentication.authenticationProvider(authenticationProvider());
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		   authenticationProvider.setPasswordEncoder(passwordEncoder());
		   System.out.println();
		return authenticationProvider;
	}
	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/resources/**").permitAll()
		.antMatchers("/register").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")  
		.anyRequest().authenticated().and()
		.formLogin().
		loginPage("/login").permitAll()
		.and().logout().permitAll();
	}

	
}
