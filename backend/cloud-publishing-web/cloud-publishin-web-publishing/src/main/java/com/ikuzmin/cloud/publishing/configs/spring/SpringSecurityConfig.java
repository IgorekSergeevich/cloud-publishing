package com.ikuzmin.cloud.publishing.configs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Igor Kuzmin
 */
@Profile({"development", "production"})
@EnableWebSecurity
@ComponentScan("com.ikuzmin.cloud.publishing.configs.security")
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationProvider authenticationProvider;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
              .antMatchers("/resources/**").permitAll()
              .anyRequest().authenticated()
            .and()
              .formLogin().permitAll().loginPage("/login").failureUrl("/login?err")
              .loginProcessingUrl("/login/processing")
              .usernameParameter("login").passwordParameter("password")
              .defaultSuccessUrl("/employees")
            .and()
              .logout().logoutUrl("/logout");
  }
  
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
