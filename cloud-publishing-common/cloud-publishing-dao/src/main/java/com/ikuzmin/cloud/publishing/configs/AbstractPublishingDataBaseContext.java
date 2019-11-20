package com.ikuzmin.cloud.publishing.configs;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


/**
 *
 * @author Igor Kuzmin
 */

public class AbstractPublishingDataBaseContext {

  @Bean
  public DataSource basicDataSource() {
    BasicDataSource dataSource = new BasicDataSource();
    dataSource.setUrl("jdbc:mysql://localhost:3306/cloud-publishing?serverTimezone=UTC");
    dataSource.setUsername("root");
    dataSource.setPassword("root");
    dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    dataSource.setInitialSize(5);
    dataSource.setMaxTotal(20);
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
    properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    properties.put("hibernate.show_sql", "true");
    properties.put("hibernate.format_sql", "true");
    return properties;
  }
  
}
