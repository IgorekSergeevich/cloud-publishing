package com.ikuzmin.employee.rest.configs.spring;

import com.ikuzmin.cloud.publishing.configs.AbstractPublishingDataBaseContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@ComponentScan({"com.ikuzmin.employee.rest.service", "com.ikuzmin.employee.rest.dao"})
@EnableTransactionManagement
public class EmplyeeServiceRootContext extends AbstractPublishingDataBaseContext {
  
}
