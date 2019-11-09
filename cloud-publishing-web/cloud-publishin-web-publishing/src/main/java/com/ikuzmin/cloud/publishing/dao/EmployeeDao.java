package com.ikuzmin.cloud.publishing.dao;

import com.ikuzmin.cloud.publishing.entitys.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Igor Kuzmin
 */
@Repository
public class EmployeeDao {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;
  
  private List<Employee> dataSource;
  
  @PostConstruct
  public void EmployeeDaoInit() {
    dataSource = new ArrayList<>();
    dataSource.add(new Employee(1, "kuzmin-igor@bk.ru", passwordEncoder.encode("1234")));
  }
  
  public Optional<Employee> getEmployeeByEmail(String email) {
    return dataSource.stream()
      .filter(e -> e.getEmail().equals(email))
      .findAny();
  }

}
