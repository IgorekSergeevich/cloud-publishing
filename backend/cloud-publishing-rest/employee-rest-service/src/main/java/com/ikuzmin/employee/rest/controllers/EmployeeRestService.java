package com.ikuzmin.employee.rest.controllers;

import com.ikuzmin.employee.rest.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.ikuzmin.cloud.publishing.model.entitys.Employee;

/**
 *
 * @author Igor Kuzmin
 */

@RestController("/employee")
public class EmployeeRestService {
  
  @Autowired
  private EmployeeService employeeService;
  
  @GetMapping("/all")
  public ResponseEntity<List<Employee>> getAllEmployee() {
    List<Employee> result = employeeService.getAllEmployee();
    if (result.isEmpty()) {
      return ResponseEntity.noContent().build();
    } else {
      return ResponseEntity.ok(result);
    }
  }
 
  /*@GetMapping("{login}")
  public ResponseEntity<Employee> getEmployeeByLogin(@PathVariable String login) {
    return employeeService.getEmployeeByLogin(login)
      .map(employee -> ResponseEntity.ok(employee))
      .orElseGet(() -> ResponseEntity.noContent().build());
  }*/
  
}
