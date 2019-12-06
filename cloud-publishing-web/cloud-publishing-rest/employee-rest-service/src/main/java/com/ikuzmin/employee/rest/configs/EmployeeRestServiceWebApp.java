package com.ikuzmin.employee.rest.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



/**
 *
 * @author Igor Kuzmin
 */
@SpringBootApplication
public class EmployeeRestServiceWebApp extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeRestServiceWebApp.class, args);
  }

}
