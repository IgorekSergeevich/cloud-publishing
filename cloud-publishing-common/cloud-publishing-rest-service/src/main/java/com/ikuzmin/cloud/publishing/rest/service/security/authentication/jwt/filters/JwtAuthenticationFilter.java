package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.filters;

import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 *
 * @author Igor Kuzmin
 */
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  public JwtAuthenticationFilter() {
    super("/**");
  }
  
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, 
          HttpServletResponse respons) throws AuthenticationException, 
          IOException, ServletException {
    
    String header = request.getHeader("Authorization");
    if (header == null && !header.startsWith("Bearer ")) {
      throw new AuthenticationCredentialsNotFoundException("Header not found");
    }
    String token = header.substring(7);
    Jwts.parser();
    
    return getAuthenticationManager().authenticate(null);
  }
  
}
