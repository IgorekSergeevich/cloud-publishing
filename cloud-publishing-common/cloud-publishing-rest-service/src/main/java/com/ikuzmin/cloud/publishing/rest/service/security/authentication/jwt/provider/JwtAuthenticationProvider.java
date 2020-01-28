package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.provider;

import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.token.JwtToken;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/**
 *
 * @author Igor Kuzmin
 */
public class JwtAuthenticationProvider implements AuthenticationProvider {

  @Getter
  @Setter
  private UserDetailsService userDetailsService;
  
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UserDetails entity = userDetailsService.loadUserByUsername(authentication.getName());
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
