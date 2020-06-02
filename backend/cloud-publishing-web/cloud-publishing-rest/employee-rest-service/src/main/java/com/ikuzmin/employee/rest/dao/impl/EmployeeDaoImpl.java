package com.ikuzmin.employee.rest.dao.impl;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import com.ikuzmin.employee.rest.dao.EmployeeDao;
import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
  public Optional<Employee> getEmployeeByLogin(String login) {
    Session session = sessionFactory.openSession();
    Query<Employee> query = session.createQuery("from Employee e where e.login = :login");
    query.setParameter("login", login);
    Optional<Employee> employee = query.getResultStream().findFirst();
    session.close();
    return employee;
  }
  
  @Override
  public List<Employee> getAllEmployee() {
    Session session = sessionFactory.openSession();
    List<Employee> employees = session.createQuery("from Employee").getResultList();
    session.close();
    return employees;
  }
  
}
