package com.ikuzmin.cloud.publishing.services;

import com.ikuzmin.cloud.publishing.configs.security.PublishingUserDetails;
import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Kuzmin
 */
@Service
public class SecurityService {
  
  public Employee getLoggedEmployee() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
      return null;
    }
    PublishingUserDetails user = (PublishingUserDetails)authentication.getPrincipal();
    return user.getEmployee();
  }
  
}
