package com.ikuzmin.cloud.publishing.rest.client;

import com.ikuzmin.cloud.publishing.model.Employee;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Igor Kuzmin
 */
public class EmployeeRestClient {
  
  private RestTemplate restTemplate;
  
  public EmployeeRestClient(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }
  
  public Employee getEmployeeByLogin(String login) {
    return restTemplate.getForObject("http://localhost:8081/employee-rest-service/employees/{login}", Employee.class, login);
  }
  
}
