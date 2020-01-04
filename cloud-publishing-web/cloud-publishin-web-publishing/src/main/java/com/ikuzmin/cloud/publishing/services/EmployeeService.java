package com.ikuzmin.cloud.publishing.services;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import com.ikuzmin.cloud.publishing.rest.client.EmployeeRestClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Igor Kuzmin
 */

@Service
public class EmployeeService {
  
  @Autowired
  private EmployeeRestClient employeeRestClient;
  
  public List<Employee> getAllEmployee() {
    return employeeRestClient.getAllEmployee();
  }
  
}
