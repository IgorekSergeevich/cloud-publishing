package com.ikuzmin.cloud.publishin.web.publishing.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author Igor Kuzmin
 */

@Configuration
@EnableWebMvc
@ComponentScan("com.ikuzmin.cloud.publishin.web.publishing.controllers")
public class DispatcherServletConfig implements WebMvcConfigurer {
  
  @Bean
  public ViewResolver internalResourceViewResolver() {
      InternalResourceViewResolver bean = new InternalResourceViewResolver();
      bean.setViewClass(JstlView.class);
      bean.setPrefix("WEB-INF/view/");
      bean.setSuffix(".jsp");
      return bean;
  }
  
}
