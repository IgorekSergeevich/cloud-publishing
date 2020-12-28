package com.ikuzmin.employee.rest

import com.ikuzmin.cloud.publishing.model.entities.Employee
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication


@SpringBootApplication
@EntityScan(basePackageClasses = [Employee::class])
class EmployeeRestServiceWebApp

fun main(args: Array<String>) {
    runApplication<EmployeeRestServiceWebApp>(*args)
}