package com.ikuzmin.cloud.publishin.web.publishing.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Igor Kuzmin
 */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
      .passwordEncoder(passwordEncoder)
      .withUser("Igor").password(passwordEncoder.encode("Igor")).roles("ADMIN");
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/main").hasRole("ADMIN")
      .antMatchers("/").authenticated()
      .and()
      .formLogin().permitAll().loginPage("/login").failureUrl("/login?err")
      .loginProcessingUrl("/login/processing")
      .usernameParameter("login").passwordParameter("password")
      .defaultSuccessUrl("/main", true);
  }
  
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
