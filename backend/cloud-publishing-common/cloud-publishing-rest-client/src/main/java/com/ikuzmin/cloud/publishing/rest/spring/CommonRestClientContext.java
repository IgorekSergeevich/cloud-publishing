package com.ikuzmin.cloud.publishing.rest.spring;

import com.ikuzmin.cloud.publishing.rest.client.factory.RestClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@PropertySource("classpath:rest-client.properties")
public class CommonRestClientContext {
  
  @Value("${rest.client.username}")
  private String appUserName;
  
  @Value("${rest.client.password}")
  private String appUserPassword;
  
  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.getInterceptors()
            .add(new BasicAuthenticationInterceptor(appUserName, appUserPassword));
    return restTemplate;
  }
  
  @Bean
  public RestClientFactory restClientFactory(RestTemplate restTemplate, @Value("${hostUrl}") String hostUrl) {
    return new RestClientFactory(restTemplate, hostUrl);
  }
  
}
