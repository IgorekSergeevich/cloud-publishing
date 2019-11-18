package com.ikuzmin.employee.rest.rest;

import com.ikuzmin.cloud.publishing.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Igor Kuzmin
 */

@RestController
public class EmployeeRestService {
  
  @GetMapping("/{email}")
  public Employee getEmployeeByEmail(@PathVariable String email) {
    Employee e = new Employee();
    e.setEmail(email);
    return e;
  }
  
  
}
