package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Igor Kuzmin
 */

@ComponentScan({"com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.service", 
  "com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.util"})
public class CommonRestServiceSecurityContextJwtAuth extends WebSecurityConfigurerAdapter {
  
  /*@Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
              .authorizeRequests()
              .anyRequest().authenticated()
            .and()
              .httpBasic();    
  }*/
  
}
