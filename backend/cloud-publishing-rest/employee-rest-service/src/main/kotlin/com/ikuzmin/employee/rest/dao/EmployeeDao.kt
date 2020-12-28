package com.ikuzmin.employee.rest.dao

import com.ikuzmin.cloud.publishing.model.entities.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeDao: JpaRepository<Employee, Int>