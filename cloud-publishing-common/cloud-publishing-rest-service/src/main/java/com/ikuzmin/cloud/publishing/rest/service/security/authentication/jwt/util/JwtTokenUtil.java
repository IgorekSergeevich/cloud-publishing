package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.util;

import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.service.SecretService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 *
 * @author Igor Kuzmin
 */

@Component
public class JwtTokenUtil {
  
  @Autowired
  private SecretService secretService;
  
  public String generateTokenWithHS256Sign() {
    return Jwts.builder()
            .setSubject("Igor")
            .claim("roles", "Editor")
            .signWith(SignatureAlgorithm.HS256, secretService.getByte64Hs256Secret())
            .compact();
  }
  
}
