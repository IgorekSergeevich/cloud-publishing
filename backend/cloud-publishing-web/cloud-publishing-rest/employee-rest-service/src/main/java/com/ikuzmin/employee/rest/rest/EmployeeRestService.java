package com.ikuzmin.employee.rest.rest;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import com.ikuzmin.employee.rest.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
  
  @GetMapping("/employees")
  public ResponseEntity<List<Employee>> getAllEmployee() {
    List<Employee> result = employeeService.getAllEmployee();
    if (result.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.ok(result);
    }
  }
 
  @GetMapping("/employees/{login}")
  public ResponseEntity<Employee> getEmployeeByLogin(@PathVariable String login) {
    return employeeService.getEmployeeByLogin(login)
      .map(employee -> ResponseEntity.ok(employee))
      .orElseGet(() -> ResponseEntity.noContent().build());
  }
  
}
