package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.cloud.publishing.model.entities.Employee
import com.ikuzmin.employee.rest.dao.EmployeeDao
import com.ikuzmin.employee.rest.services.EmployeeService
import org.springframework.stereotype.Service


@Service
class EmployeeServiceImpl constructor(
    val employeeDao: EmployeeDao
): EmployeeService {

    override fun getAllEmployee(): List<Employee> = employeeDao.findAll()

}