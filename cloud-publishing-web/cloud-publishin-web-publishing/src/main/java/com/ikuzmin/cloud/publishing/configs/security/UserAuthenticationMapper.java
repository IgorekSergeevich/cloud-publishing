package com.ikuzmin.cloud.publishing.configs.security;

import com.ikuzmin.cloud.publishing.model.Employee;
import com.ikuzmin.cloud.publishing.rest.client.EmployeeRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Igor Kuzmin
 */

@Component
public class UserAuthenticationMapper {
  
  @Autowired
  private EmployeeRestClient employeeRestClient;
  
  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  public UserDetails createUser(Authentication authentication) {
    ResponseEntity<Employee> employee = employeeRestClient.getEmployeeByLogin(authentication.getName());
    if (!employee.hasBody()) {
      throw new UsernameNotFoundException("Employee not found in data base!");
    } else {
      String password = authentication.getCredentials().toString();
      if (!passwordEncoder.matches(password, employee.getBody().getPassword())) {
        throw new BadCredentialsException("Invalid password for user!");
      }
    }
    return new PublishingUserDetails(employee.getBody());
  }
  
}
