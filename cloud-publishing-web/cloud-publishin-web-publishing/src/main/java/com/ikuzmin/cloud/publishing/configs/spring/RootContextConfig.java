package com.ikuzmin.cloud.publishing.configs.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@Import(SpringSecurityConfig.class)
@ComponentScan("com.ikuzmin.cloud.publishing.dao")
public class RootContextConfig {
 
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
