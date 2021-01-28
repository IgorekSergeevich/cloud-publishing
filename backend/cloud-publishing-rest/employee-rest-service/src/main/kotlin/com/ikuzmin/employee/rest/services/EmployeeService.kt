package com.ikuzmin.employee.rest.services

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Education
import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser


interface EmployeeService {

    fun getEmployeesProfiles(): List<ProfileDto>

    fun createEmployee(userProfile: ProfileDto)

    fun getEducationList(): List<Education>

    fun getUserPhoto(userId: Int): ByteArray?
}