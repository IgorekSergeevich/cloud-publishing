package com.ikuzmin.employee.rest.dao.impl;

import com.ikuzmin.cloud.publishing.model.Employee;
import com.ikuzmin.employee.rest.dao.EmployeeDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Igor Kuzmin
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

  @Autowired
  private SessionFactory sessionFactory;
  
  @Override
  public Employee getEmployeeById(Integer id) {
    Session session = sessionFactory.openSession();
    Employee employee = session.get(Employee.class, id);
    session.close();
    return employee;
  }
  
}
