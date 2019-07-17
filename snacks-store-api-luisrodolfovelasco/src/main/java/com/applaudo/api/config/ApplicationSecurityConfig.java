package com.applaudo.api.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private Logger logger = LoggerFactory.getLogger(ApplicationSecurityConfig.class);
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
        authentication.inMemoryAuthentication()
	        .withUser("user").password("user").roles("USER").and()
	        .withUser("rodol").password("user").roles("USER").and()
	        .withUser("applaudo").password("user").roles("USER").and()
	        .withUser("admin").password("admin").roles("ADMIN");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	this.logger.info("*** Access Control List (ACL) ***");
    	
    	http.csrf().disable().authorizeRequests()
    	.antMatchers(HttpMethod.GET).permitAll()
    	.antMatchers(HttpMethod.POST,"/product/create/**").hasRole("ADMIN")
    	.antMatchers(HttpMethod.DELETE,"/product/delete/**").hasRole("ADMIN")
    	.antMatchers(HttpMethod.POST,"/product/like/**").hasRole("USER")
    	.antMatchers(HttpMethod.PUT,"/product/update/**").hasRole("ADMIN")
    	.antMatchers(HttpMethod.POST,"/product/purchase").hasRole("USER")
    	.anyRequest().fullyAuthenticated()
    	.and().httpBasic();
    	
    	this.logger.info("*** ACL ***");
    }
}