package com.ikuzmin.cloud.publishing.rest.client.factory;

import com.ikuzmin.cloud.publishing.rest.client.AbstractRestClient;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Igor Kuzmin
 */
@AllArgsConstructor
public class RestClientFactory {
  
  private static final String HTTP_PREFIX = "http";
  
  private RestTemplate restTemplate;
  
  private String hostUrl;
  
  public <T extends AbstractRestClient> T createRestClient(Supplier<T> supplier, String serviceUrl) {
    T restClient = supplier.get();
    restClient.setRestTemplate(restTemplate);
    if (!serviceUrl.startsWith(HTTP_PREFIX)) {
      restClient.setServiceUrl(hostUrl.concat(serviceUrl));
    } else {
      restClient.setServiceUrl(serviceUrl);
    }
    return restClient;
  } 
  
}
