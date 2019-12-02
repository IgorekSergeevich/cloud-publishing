package com.ikuzmin.cloud.publishing.configs.spring;

import com.ikuzmin.cloud.publishing.rest.spring.RestClientContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@Import({SpringSecurityConfig.class, RestClientContext.class})
public class RootContextConfig {
  
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
}
