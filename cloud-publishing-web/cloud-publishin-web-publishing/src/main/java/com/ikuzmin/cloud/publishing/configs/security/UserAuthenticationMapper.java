package com.ikuzmin.cloud.publishing.configs.security;

import com.ikuzmin.cloud.publishing.model.Employee;
import com.ikuzmin.cloud.publishing.rest.client.EmployeeRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Igor Kuzmin
 */

@Component
public class UserAuthenticationMapper {
  
  @Autowired
  private EmployeeRestClient employeeRestClient;
  
  public PublishingUserDetails createUser(Authentication authentication) {
    ResponseEntity<Employee> employee = employeeRestClient.getEmployeeByLogin(authentication.getName());
    if (!employee.hasBody()) {
      throw new UsernameNotFoundException("Employee not found!");
    } 
    return new PublishingUserDetails(employee.getBody());
  }
  
}
