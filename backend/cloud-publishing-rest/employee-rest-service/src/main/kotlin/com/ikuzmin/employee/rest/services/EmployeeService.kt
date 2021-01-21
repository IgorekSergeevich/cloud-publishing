package com.ikuzmin.employee.rest.services

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser


interface EmployeeService {
    fun getAllEmployee(): List<Profile>

    fun getEmployeesProfiles(): List<ProfileDto>

    fun createEmployee(keycloakUser: KeycloakUser)
}