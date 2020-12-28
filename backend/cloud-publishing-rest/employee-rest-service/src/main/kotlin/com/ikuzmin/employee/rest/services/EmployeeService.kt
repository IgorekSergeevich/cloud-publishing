package com.ikuzmin.employee.rest.services

import com.ikuzmin.cloud.publishing.model.entities.Employee


interface EmployeeService {
    fun getAllEmployee(): List<Employee>
}