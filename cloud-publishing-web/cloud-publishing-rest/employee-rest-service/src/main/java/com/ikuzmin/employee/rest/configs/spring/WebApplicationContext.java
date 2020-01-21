package com.ikuzmin.employee.rest.configs.spring;

import com.ikuzmin.cloud.publishing.configs.AbstractPublishingDataBaseContext;
import com.ikuzmin.cloud.publishing.rest.service.security.CommonRestServiceSecurityContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@ComponentScan({"com.ikuzmin.employee.rest.services.impl", "com.ikuzmin.employee.rest.dao.impl", "com.ikuzmin.employee.rest.rest"})
@Import({CommonRestServiceSecurityContext.class})
@EnableTransactionManagement
public class WebApplicationContext extends AbstractPublishingDataBaseContext {
  
}
