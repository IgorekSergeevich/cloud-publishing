package com.ikuzmin.cloud.publishing.rest.client;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Igor Kuzmin
 */
public class EmployeeRestClient extends AbstractRestClient{
  
  private String employeeByLogin;
  private String allEmployee;
  
  @Override
  public void setServiceUrl(String serviceUrl) {
    super.setServiceUrl(serviceUrl);
    allEmployee = this.serviceUrl + "/employees";
    employeeByLogin = this.serviceUrl + "/employees/{login}";
    
  }
  
  public Employee getEmployeeByLogin(String login) {
    ResponseEntity<Employee> result = restTemplate.getForEntity(employeeByLogin, Employee.class, login);
    if (result.hasBody()) {
      return result.getBody();
    } else {
      return null;
    }
  }
  
  public List<Employee> getAllEmployee() {
    ResponseEntity<Employee[]> result = restTemplate.getForEntity(allEmployee, Employee[].class);
    if (result.hasBody()) {
      return Arrays.asList(result.getBody());
    } else {
      return Collections.emptyList();
    }
  }
  
}
