package com.ikuzmin.cloud.publishing.configs;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


/**
 *
 * @author Igor Kuzmin
 */

@PropertySource("classpath:data-source-properties.properties")
public class AbstractPublishingDataBaseContext {

  @Autowired
  private Environment environment;
  
  @Bean
  public DataSource basicDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setUrl(environment.getProperty("db.url"));
    dataSource.setUsername(environment.getProperty("db.username"));
    dataSource.setPassword(environment.getProperty("db.password"));
    dataSource.setDriverClassName(environment.getProperty("db.drivername"));
    dataSource.setInitialSize(environment.getProperty("db.initial_poolsize", Integer.class));
    dataSource.setMaxTotal(environment.getProperty("db.max_poolsize", Integer.class));
    return dataSource;
  }
  
  @Bean
  public LocalSessionFactoryBean sessionFactoryBean() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(basicDataSource());
    sessionFactoryBean.setPackagesToScan("com.ikuzmin.cloud.publishing.model");
    sessionFactoryBean.setHibernateProperties(hibernateProperties());
    return sessionFactoryBean;
  }
  
  @Bean
  public PlatformTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactoryBean().getObject());
    return transactionManager;
  }
  
  private Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
    properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
    properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
    return properties;
  }
  
}
