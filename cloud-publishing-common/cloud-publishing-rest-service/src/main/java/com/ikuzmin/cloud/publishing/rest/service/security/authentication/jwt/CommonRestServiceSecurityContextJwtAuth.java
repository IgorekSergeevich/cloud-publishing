package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt;

import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.filters.JwtAuthenticationFilter;
import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.provider.JwtAuthenticationProvider;
import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.service.SecretService;
import java.io.IOException;
import java.util.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Igor Kuzmin
 */

@EnableWebSecurity
@ComponentScan({
  "com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.service"
  })
public class CommonRestServiceSecurityContextJwtAuth extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private SecretService secretService;
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(jwtAuthenticationProvider());
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.addFilterBefore(new JwtAuthenticationFilter(secretService, authenticationManager()), 
            UsernamePasswordAuthenticationFilter.class)
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated();   
  }
  
  @Bean
  public UserDetailsService userDetailsManager() throws IOException {
    Resource resource = new ClassPathResource("rest-service-users.properties");
    Properties properties = new Properties();
    properties.load(resource.getInputStream());
    return new InMemoryUserDetailsManager(properties);
  }
  
  @Bean
  public AuthenticationProvider jwtAuthenticationProvider() throws IOException {
    JwtAuthenticationProvider provider = new JwtAuthenticationProvider();
    provider.setUserDetailsService(userDetailsManager());
    return provider;
  }
  
}
