package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Igor Kuzmin
 */

@EnableWebSecurity
@ComponentScan({"com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.filters",
  "com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.provider",
  "com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.service"
  })
public class CommonRestServiceSecurityContextJwtAuth extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private AuthenticationProvider provider;
  
  @Autowired
  private AbstractAuthenticationProcessingFilter jwtFilter;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(provider);
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated();   
  }
  
  @Bean
  public UserDetailsManager userDetailsManager() {
    UserDetails u1 = User.builder().username("cloud-publishing-app").build();
    UserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
    userDetailsManager.createUser(u1);
    return userDetailsManager;
  }
  
}
