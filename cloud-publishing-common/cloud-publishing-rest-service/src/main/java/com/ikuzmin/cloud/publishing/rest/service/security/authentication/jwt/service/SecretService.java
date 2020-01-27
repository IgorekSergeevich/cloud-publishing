package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.service;

import java.util.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Kuzmin
 */
@Service
@PropertySource("classpath:jwt-secrets.properties")
public class SecretService {
  
  @Value("${secret.HS256}")
  private String secretHS256;

  public String getByte64Hs256Secret() {
    return secretHS256;
  }
  
}
