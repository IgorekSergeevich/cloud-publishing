package com.ikuzmin.cloud.publishing.configs.security;

import com.ikuzmin.cloud.publishing.model.Employee;
import com.ikuzmin.cloud.publishing.rest.client.EmployeeRestClient;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
    Optional<Employee> employee = employeeRestClient.getEmployeeByLogin(authentication.getName());
    if (employee.isEmpty()) {
      throw new UsernameNotFoundException("Employee not found in data base!");
    } else {
      System.out.println(employee.get().getPassword());
      String password = authentication.getCredentials().toString();
      if (!passwordEncoder.matches(password, employee.get().getPassword())) {
        throw new BadCredentialsException("Invalid password for user!");
      }
    }
    return new PublishingUserDetails(employee.get());
  }
  
}
