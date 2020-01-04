package com.ikuzmin.employee.rest.dao;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import java.util.Optional;

/**
 *
 * @author Igor Kuzmin
 */
public interface EmployeeDao {
  
  Employee getEmployeeById(Integer id);
  
  Optional<Employee> getEmployeeByLogin(String login);
  
}
