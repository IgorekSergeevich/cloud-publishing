package com.ikuzmin.employee.rest.dao;

import com.ikuzmin.cloud.publishing.model.Employee;

/**
 *
 * @author Igor Kuzmin
 */
public interface EmployeeDao {
  
  Employee getEmployeeById(Integer id);
  
}
