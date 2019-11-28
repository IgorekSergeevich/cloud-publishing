package com.ikuzmin.cloud.publishing.rest.client;

import com.ikuzmin.cloud.publishing.model.Employee;

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
  
  public Employee getEmployeeByLogin(String login) {
    return restTemplate.getForObject(employeeByLogin, Employee.class, login);
  }
  
}
