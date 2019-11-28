package com.ikuzmin.cloud.publishing.rest.client;

import lombok.Setter;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Igor Kuzmin
 */
public abstract class AbstractRestClient {
  
  @Setter
  protected String serviceUrl;
  
  @Setter
  protected RestTemplate restTemplate;
  
}
