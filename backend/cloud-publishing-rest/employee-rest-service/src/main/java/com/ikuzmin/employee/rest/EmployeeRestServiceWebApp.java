package com.ikuzmin.employee.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import com.ikuzmin.cloud.publishing.model.entitys.Employee;


/**
 *
 * @author Igor Kuzmin
 */
@SpringBootApplication
@EntityScan(basePackageClasses = Employee.class)
public class EmployeeRestServiceWebApp extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeRestServiceWebApp.class, args);
  }

}
