package com.ikuzmin.employee.rest.services;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import java.util.Optional;

/**
 *
 * @author Igor Kuzmin
 */
public interface EmployeeService {
  
  Employee getEmployeeById(Integer id);
  
  Optional<Employee> getEmployeeByLogin(String login);
  
}
