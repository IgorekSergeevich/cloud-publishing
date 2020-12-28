package com.ikuzmin.employee.rest.controllers

import com.ikuzmin.cloud.publishing.model.entities.Employee
import com.ikuzmin.employee.rest.services.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/employee")
class EmployeeRestController(
    val employeeService: EmployeeService
) {

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    fun getAllEmployee(): ResponseEntity<List<Employee>> {
        val result = employeeService.getAllEmployee()
        return if (result.isEmpty())
            ResponseEntity.noContent().build()
        else
            ResponseEntity.ok(result)
    }
}