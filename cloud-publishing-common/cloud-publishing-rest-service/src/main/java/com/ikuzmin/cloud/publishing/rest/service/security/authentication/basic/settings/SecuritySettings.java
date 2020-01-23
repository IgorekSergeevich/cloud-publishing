package com.ikuzmin.cloud.publishing.rest.service.security.authentication.basic.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Igor Kuzmin
 */

@Data
@Component
@PropertySource("classpath:rest-service-users.properties")
@ConfigurationProperties(prefix = "cloud.publishing.user")
public class SecuritySettings {
  
  @Data
  public static class ServiceUser {
    private String username;
    private String password;
  }
  
  private ServiceUser app;
  
}
