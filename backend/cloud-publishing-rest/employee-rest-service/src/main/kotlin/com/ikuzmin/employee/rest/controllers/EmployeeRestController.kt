package com.ikuzmin.employee.rest.controllers

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.dto.ShortProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Education
import com.ikuzmin.employee.rest.services.EmployeeService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("/employee")
class EmployeeRestController(
    val employeeService: EmployeeService
) {

    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/profiles")
    fun getEmployeeProfiles(): ResponseEntity<List<ProfileDto>> =
        ResponseEntity.ok(employeeService.getEmployeesProfiles())


    @CrossOrigin
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    fun createNewEmployee(@RequestBody userProfile: ProfileDto): ResponseEntity<Void> {
        employeeService.createEmployee(userProfile)
        return ResponseEntity.ok().build()
    }

    @CrossOrigin
    @GetMapping("/educations")
    fun getEducationList(): ResponseEntity<List<Education>> =
        ResponseEntity.ok(employeeService.getEducationList())

    @CrossOrigin
    @GetMapping("/shortProfile")
    fun getShortProfile(principal: Principal): ResponseEntity<ShortProfileDto>
        = ResponseEntity.ok(employeeService.getShortProfile(principal))

    @CrossOrigin
    @GetMapping("/photo/{login}")
    fun getUserPhoto(@PathVariable login: String) =
        ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG)
            .body(employeeService.getUserPhoto(login))
}