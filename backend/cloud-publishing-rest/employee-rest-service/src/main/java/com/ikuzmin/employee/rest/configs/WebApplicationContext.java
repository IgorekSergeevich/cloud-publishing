package com.ikuzmin.employee.rest.configs;

import com.ikuzmin.cloud.publishing.configs.AbstractPublishingDataBaseContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Igor Kuzmin
 */
@Configuration
@EnableTransactionManagement
public class WebApplicationContext extends AbstractPublishingDataBaseContext {
  
}
