package com.ikuzmin.cloud.publishing.rest.spring;

import com.ikuzmin.cloud.publishing.rest.client.EmployeeRestClient;
import com.ikuzmin.cloud.publishing.rest.client.factory.RestClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@Import(CommonRestClientContext.class)
public class RestClientContext {
  
  @Autowired
  private RestClientFactory restClientFactory;
  
  @Bean
  public EmployeeRestClient employeeRestClient(@Value("${employee.rest.service}") String serviceUrl) {
    return restClientFactory.createRestClient(EmployeeRestClient::new, serviceUrl);
  }
  
}
