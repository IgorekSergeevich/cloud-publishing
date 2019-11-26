package com.ikuzmin.cloud.publishing.rest.spring;

import com.ikuzmin.cloud.publishing.rest.client.EmployeeRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
public class RestClientContext {
  
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
  @Bean
  public EmployeeRestClient employeeRestClient(RestTemplate restTemplate) {
    return new EmployeeRestClient(restTemplate);
  }
  
}
