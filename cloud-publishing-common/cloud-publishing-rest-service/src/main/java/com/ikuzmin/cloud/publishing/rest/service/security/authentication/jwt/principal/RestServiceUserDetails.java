package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.principal;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 *
 * @author Igor Kuzmin
 */
public class RestServiceUserDetails extends User {
  
  public RestServiceUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }
  
}
