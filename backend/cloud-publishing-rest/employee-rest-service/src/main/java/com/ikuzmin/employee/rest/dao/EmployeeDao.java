package com.ikuzmin.employee.rest.dao;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Igor Kuzmin
 */
public interface EmployeeDao {
  
  Optional<Employee> getEmployeeByLogin(String login);
  
  List<Employee> getAllEmployee();
  
}
