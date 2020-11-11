package com.ikuzmin.employee.rest.services.impl;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import com.ikuzmin.employee.rest.dao.EmployeeDao;
import com.ikuzmin.employee.rest.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Kuzmin
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

  @Autowired
  private EmployeeDao employeeDao;
  
  @Override
  public List<Employee> getAllEmployee() {
    return employeeDao.findAll();
  }
  
}
