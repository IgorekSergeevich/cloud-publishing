package com.ikuzmin.cloud.publishing.rest.client;

import com.ikuzmin.cloud.publishing.model.Employee;
import java.util.Optional;

/**
 *
 * @author Igor Kuzmin
 */
public class EmployeeRestClient extends AbstractRestClient{
  
  private String employeeByLogin;
  
  @Override
  public void setServiceUrl(String serviceUrl) {
    super.setServiceUrl(serviceUrl);
    employeeByLogin = this.serviceUrl + "/employees/{login}";
  }
  
  public Optional<Employee> getEmployeeByLogin(String login) {
    return restTemplate.getForObject(employeeByLogin, Optional.class, login);
  }
  
}
