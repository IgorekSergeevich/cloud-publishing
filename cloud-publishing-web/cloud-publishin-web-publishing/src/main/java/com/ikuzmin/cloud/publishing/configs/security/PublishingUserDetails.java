package com.ikuzmin.cloud.publishing.configs.security;

import com.ikuzmin.cloud.publishing.model.Employee;
import java.util.Collections;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 *
 * @author Igor Kuzmin
 */
public class PublishingUserDetails extends User {
  
  @Getter
  private Employee employee;
  
  public PublishingUserDetails(Employee employee) {
    super(employee.getLogin(), employee.getPassword(), 
            Collections.singletonList(new SimpleGrantedAuthority("ADMIN")));
    this.employee = employee;
  }
  
}
