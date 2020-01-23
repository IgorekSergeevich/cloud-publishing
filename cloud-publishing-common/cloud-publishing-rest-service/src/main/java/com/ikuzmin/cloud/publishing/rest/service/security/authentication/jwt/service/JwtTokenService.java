package com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.service;

import com.ikuzmin.cloud.publishing.rest.service.security.authentication.jwt.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Kuzmin
 */

@Service
public class JwtTokenService {
  
  @Autowired
  private JwtTokenUtil jwtTokenUtil;
  
  public String getTokenWithHs256Sign() {
    return jwtTokenUtil.generateTokenWithHS256Sign();
  }
  
}
