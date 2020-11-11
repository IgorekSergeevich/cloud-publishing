package com.ikuzmin.employee.rest.dao;

import com.ikuzmin.cloud.publishing.model.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Igor Kuzmin
 */
public interface EmployeeDao extends JpaRepository<Employee, Integer> {
}
