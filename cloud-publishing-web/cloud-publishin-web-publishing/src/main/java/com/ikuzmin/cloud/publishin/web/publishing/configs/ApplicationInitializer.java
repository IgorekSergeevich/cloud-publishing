package com.ikuzmin.cloud.publishin.web.publishing.configs;
import org.springframework.web.context.AbstractContextLoaderInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 *
 * @author Igor Kuzmin
 */
     
public class ApplicationInitializer extends AbstractContextLoaderInitializer{

  @Override
  protected WebApplicationContext createRootApplicationContext() {
    AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
    applicationContext.register(SpringSecurityConfig.class);
    return applicationContext; 
  }
  
}
