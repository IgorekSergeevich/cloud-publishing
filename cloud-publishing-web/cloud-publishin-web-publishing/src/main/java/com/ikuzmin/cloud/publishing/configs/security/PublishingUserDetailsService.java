package com.ikuzmin.cloud.publishing.configs.security;

import com.ikuzmin.cloud.publishing.dao.EmployeeDao;
import com.ikuzmin.cloud.publishing.entitys.Employee;
import java.util.Optional;
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
  private EmployeeDao employeeDao;
  
  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<Employee> emOptional = employeeDao.getEmployeeByEmail(email);
    Employee employee = emOptional
      .orElseThrow(() -> new UsernameNotFoundException("Employee not found"));
    return new PublishingUserDetails(employee);
  }

}
