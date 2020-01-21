package com.ikuzmin.cloud.publishing.rest.service.security.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Igor Kuzmin
 */

@Data
@PropertySource("classpath:rest-service-users.properties")
@ConfigurationProperties(prefix = "cloud.publishing.user")
public class SecuritySettings {
  
  @Data
  public static class ServiceUser {
    private String username;
    private String password;
  }
  
  private ServiceUser ed;
  
  private ServiceUser ce;
  
  private ServiceUser jo;
  
}
