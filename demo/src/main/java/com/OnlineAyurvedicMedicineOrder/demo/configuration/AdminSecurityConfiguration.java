package com.OnlineAyurvedicMedicineOrder.demo.configuration;
/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.OnlineAyurvedicMedicineOrder.demo.service.CustomUserDetailsService;

@Configuration
@Order(1)
public class AdminSecurityConfiguration {
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder1() {  //To hash the password during login
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean           //Uses Data Access Object to retrieve userInfo from our Database
	public DaoAuthenticationProvider authenticationProvider1() {//References Details Service,enabling password encoder
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(passwordEncoder1());
		return provider;
	}
	@Bean   //Deals in httpServlet requests contains all the filters for restricting or granting access
	public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception { 
		http.authenticationProvider(authenticationProvider1());
		
		http.authorizeRequests().antMatchers("/").permitAll();
		http.antMatcher("/admin/**").authorizeRequests().anyRequest().hasAuthority("ADMIN")
		.and()
		.formLogin()
		.loginPage("/admin/login")
		.usernameParameter("email")
		.loginProcessingUrl("/admin/login")
		.defaultSuccessUrl("/admin/home")
		.permitAll()
		.and()
		.logout().logoutUrl("/admin/logout")
		.logoutSuccessUrl("/");
		return http.build();
	}
}
*/