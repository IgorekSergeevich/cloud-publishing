package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.filters;

import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.principal.RestServiceUserDetails;
import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.service.SecretService;
import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.token.JwtToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

/**
 *
 * @author Igor Kuzmin
 */

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  @Getter
  @Setter
  private SecretService secretService;
  
  public JwtAuthenticationFilter(SecretService secretService, 
          AuthenticationManager authenticationManager) {
    super("/**");
    this.secretService = secretService;
    this.setAuthenticationManager(authenticationManager);
  }
  
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, 
          HttpServletResponse respons) throws AuthenticationException, 
          IOException, ServletException {
    
    String header = request.getHeader("Authorization");
    if (header == null || !header.startsWith("Bearer ")) {
      throw new AuthenticationCredentialsNotFoundException("Header not found");
    }
    String token = header.substring(7);
    Claims claims = Jwts.parser().setSigningKey(secretService.getByte64Hs256Secret())
            .parseClaimsJwt(token).getBody();
    RestServiceUserDetails principal = new RestServiceUserDetails(claims.getSubject(), 
            null, null);
    Authentication authentication = new JwtToken(principal, principal.getAuthorities());
    return getAuthenticationManager().authenticate(authentication);
  }
  
}
