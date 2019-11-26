package com.ikuzmin.cloud.publishing.configs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@EnableWebSecurity
@ComponentScan("com.ikuzmin.cloud.publishing.configs.security")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @Autowired
  private UserDetailsService userDetailsService;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/main").hasAnyAuthority("ADMIN")
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll().loginPage("/login").failureUrl("/login?err")
            .loginProcessingUrl("/login/processing")
            .usernameParameter("login").passwordParameter("password")
            .defaultSuccessUrl("/main", true);
  }

}
