package com.ikuzmin.cloud.publishing.rest.spring;

import com.ikuzmin.cloud.publishing.rest.client.factory.RestClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@PropertySource("classpath:rest-client.properties")
public class CommonRestClientContext {
  
  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
  @Bean
  public RestClientFactory restClientFactory(RestTemplate restTemplate, @Value("${hostUrl}") String hostUrl) {
    return new RestClientFactory(restTemplate, hostUrl);
  }
  
}
