package com.ikuzmin.employee.rest.rest;

import com.ikuzmin.cloud.publishing.model.Employee;
import com.ikuzmin.employee.rest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Igor Kuzmin
 */

@RestController
public class EmployeeRestService {
  
  @Autowired
  private EmployeeService employeeService;
  
  @GetMapping("/employee/{id}")
  public Employee getEmployeeById(@PathVariable Integer id) {
    return employeeService.getEmployeeById(id);
  }
  
  @GetMapping("/employee/{login}")
  public Employee getEmployeeById(@PathVariable String login) {
    return employeeService.getEmployeeByLogin(login);
  }
  
}
