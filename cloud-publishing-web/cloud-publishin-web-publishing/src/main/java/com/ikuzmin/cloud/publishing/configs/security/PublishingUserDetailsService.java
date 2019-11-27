package com.ikuzmin.cloud.publishing.configs.security;

import com.ikuzmin.cloud.publishing.model.Employee;
import com.ikuzmin.cloud.publishing.rest.client.EmployeeRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Kuzmin
 */

@Service
public class PublishingUserDetailsService implements UserDetailsService {
  
  @Autowired
  private EmployeeRestClient employeeRestClient;
  
  @Override
  public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
    Employee employee = employeeRestClient.getEmployeeByLogin(login);
    if (employee == null) {
      throw new UsernameNotFoundException("Employee not found");
    }
    return new PublishingUserDetails(employee);
  }

}
