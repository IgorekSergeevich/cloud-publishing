package com.ikuzmin.employee.rest.services;

import com.ikuzmin.cloud.publishing.model.Employee;

/**
 *
 * @author Igor Kuzmin
 */
public interface EmployeeService {
  
  Employee getEmployeeById(Integer id);
  
  Employee getEmployeeByLogin(String login);
  
}
