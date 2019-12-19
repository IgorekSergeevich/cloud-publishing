package com.ikuzmin.cloud.publishing.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Igor Kuzmin
 */

@Profile("development")
@Component
public class FreePasswordAuthenticationProvider implements AuthenticationProvider {
  
  @Autowired
  private UserAuthenticationService userAuthenticationService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    PublishingUserDetails userDetails = userAuthenticationService.getUserByLogin(authentication.getName());
    return new UsernamePasswordAuthenticationToken(userDetails, null, 
            userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
  
}
