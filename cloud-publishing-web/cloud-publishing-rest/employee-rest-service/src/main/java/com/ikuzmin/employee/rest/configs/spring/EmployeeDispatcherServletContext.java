package com.ikuzmin.employee.rest.configs.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Igor Kuzmin
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.ikuzmin.employee.rest.rest")
public class EmployeeDispatcherServletContext implements WebMvcConfigurer {
  
}
