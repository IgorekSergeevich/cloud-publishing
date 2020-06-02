package com.ikuzmin.cloud.publishing.rest.service.security;

import com.ikuzmin.cloud.publishing.rest.service.security.settings.SecuritySettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Igor Kuzmin
 */

@EnableWebSecurity
@EnableConfigurationProperties(SecuritySettings.class)
public class CommonRestServiceSecurityContext extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private SecuritySettings securitySettings;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
            .withUser(securitySettings.getApp().getUsername())
            .password(securitySettings.getApp().getPassword())
            .roles();
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
              .authorizeRequests()
              .anyRequest().authenticated()
            .and()
              .httpBasic();    
  }
  
}
