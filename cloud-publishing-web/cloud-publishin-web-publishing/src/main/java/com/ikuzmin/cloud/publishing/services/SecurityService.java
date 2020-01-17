package com.ikuzmin.cloud.publishing.services;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Kuzmin
 */
@Service
public class SecurityService {
  
  public boolean isAuthenticatedRequest() {
    return SecurityContextHolder.getContext().getAuthentication() != null;
  }
  
}
