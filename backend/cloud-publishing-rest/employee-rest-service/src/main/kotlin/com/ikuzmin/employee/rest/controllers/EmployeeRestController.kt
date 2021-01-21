package com.ikuzmin.employee.rest.controllers

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser
import com.ikuzmin.employee.rest.services.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/employee")
class EmployeeRestController(
    val employeeService: EmployeeService
) {

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    fun getAllEmployee(): ResponseEntity<List<Profile>> =
        ResponseEntity.ok(employeeService.getAllEmployee())


    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/profiles")
    fun getEmployeeProfile(): ResponseEntity<List<ProfileDto>> =
        ResponseEntity.ok(employeeService.getEmployeesProfiles())


    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    fun createNewEmployee(@RequestBody keycloakUser: KeycloakUser): ResponseEntity<Void> {
        employeeService.createEmployee(keycloakUser)
        return ResponseEntity.ok().build()
    }

}