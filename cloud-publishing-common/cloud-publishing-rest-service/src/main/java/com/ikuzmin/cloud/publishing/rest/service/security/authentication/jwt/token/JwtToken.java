package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.token;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Igor Kuzmin
 */
public class JwtToken extends AbstractAuthenticationToken {
  
  private UserDetails principal;
  
  public JwtToken(UserDetails principal, Collection<? extends GrantedAuthority> authoritys) {
    super(authoritys);
    this.principal = principal;
  }

  @Override
  public Object getCredentials() {
    return principal.getPassword();
  }

  @Override
  public Object getPrincipal() {
    return principal;
  }
  
}
