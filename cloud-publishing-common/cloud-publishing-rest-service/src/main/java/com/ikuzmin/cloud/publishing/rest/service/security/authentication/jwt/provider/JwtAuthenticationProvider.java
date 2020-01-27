package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.provider;

import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.token.JwtToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
/**
 *
 * @author Igor Kuzmin
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private UserDetailsManager userDetailsManager;
  
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UserDetails entity = userDetailsManager.loadUserByUsername(authentication.getName());
    if (entity == null) {
      throw new UsernameNotFoundException("User not found");
    }
    return new JwtToken(entity, entity.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> type) {
    return type.equals(JwtToken.class);
  }
  
}
