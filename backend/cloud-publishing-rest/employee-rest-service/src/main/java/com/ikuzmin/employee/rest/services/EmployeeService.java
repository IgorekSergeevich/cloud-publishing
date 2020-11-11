package com.ikuzmin.employee.rest.services;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import java.util.List;

/**
 *
 * @author Igor Kuzmin
 */
public interface EmployeeService {
  
  List<Employee> getAllEmployee();
  
  /*Optional<Employee> getEmployeeByLogin(String login);*/
  
}
