package com.ikuzmin.cloud.publishing.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author Igor Kuzmin
 */
@SpringBootApplication
public class CloudPublishingWebApp extends SpringBootServletInitializer {
  
  public static void main(String[] args) {
    SpringApplication.run(CloudPublishingWebApp.class, args);
  }
  
}
