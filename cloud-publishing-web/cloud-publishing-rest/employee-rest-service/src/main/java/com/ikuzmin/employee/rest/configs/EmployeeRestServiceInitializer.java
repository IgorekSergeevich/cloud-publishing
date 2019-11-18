package com.ikuzmin.employee.rest.configs;

import com.ikuzmin.employee.rest.configs.spring.EmployeeDispatcherServletContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

/**
 *
 * @author Igor Kuzmin
 */
public class EmployeeRestServiceInitializer extends AbstractDispatcherServletInitializer {

  @Override
  protected WebApplicationContext createServletApplicationContext() {
    AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
    context.register(EmployeeDispatcherServletContext.class);
    return context;
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/"};
  }

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    return null;
  }

 
}
