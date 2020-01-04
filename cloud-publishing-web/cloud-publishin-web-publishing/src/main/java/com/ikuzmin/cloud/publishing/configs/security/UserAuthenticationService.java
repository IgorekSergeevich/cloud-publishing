package com.ikuzmin.cloud.publishing.configs.security;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import com.ikuzmin.cloud.publishing.rest.client.EmployeeRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 *
 * @author Igor Kuzmin
 */

@Component
public class UserAuthenticationService {
  
  @Autowired
  private EmployeeRestClient employeeRestClient;
  
  public PublishingUserDetails getUserByLogin(String login) {
    ResponseEntity<Employee> employee = employeeRestClient.getEmployeeByLogin(login);
    if (!employee.hasBody()) {
      throw new UsernameNotFoundException("Employee not found!");
    } 
    return new PublishingUserDetails(employee.getBody());
  }
  
}
