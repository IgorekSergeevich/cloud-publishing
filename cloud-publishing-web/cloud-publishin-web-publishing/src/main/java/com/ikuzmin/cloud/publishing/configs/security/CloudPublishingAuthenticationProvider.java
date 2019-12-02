package com.ikuzmin.cloud.publishing.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 *
 * @author Igor Kuzmin
 */
@Component
public class CloudPublishingAuthenticationProvider implements AuthenticationProvider{

  @Autowired
  private UserAuthenticationMapper mapper;
  
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UserDetails user = mapper.createUser(authentication);
    return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
  
}
