package com.ikuzmin.employee.rest.service;

import com.ikuzmin.cloud.publishing.model.Employee;

/**
 *
 * @author Igor Kuzmin
 */
public interface EmployeeService {
  
  Employee getEmployeeById(Integer id);
  
}
