package com.ikuzmin.cloud.publishing.configs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Igor Kuzmin
 */
@Profile("production")
@Component
public class CloudPublishingAuthenticationProvider implements AuthenticationProvider {

  @Autowired
  private UserAuthenticationService userAuthenticationService;
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    PublishingUserDetails user = userAuthenticationService.getUserByLogin(authentication.getName());
    String password = authentication.getCredentials().toString();
    if (!passwordEncoder.matches(password, user.getPassword())) {
        throw new BadCredentialsException("Invalid password for user!");
    }
    return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> authentication) {
    return authentication.equals(UsernamePasswordAuthenticationToken.class);
  }
  
}
