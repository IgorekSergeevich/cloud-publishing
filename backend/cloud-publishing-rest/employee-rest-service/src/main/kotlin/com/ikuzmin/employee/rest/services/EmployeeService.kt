package com.ikuzmin.employee.rest.services

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.dto.ShortProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Education
import java.security.Principal


interface EmployeeService {

    fun getEmployeesProfiles(): List<ProfileDto>

    fun createEmployee(userProfile: ProfileDto)

    fun getEducationList(): List<Education>

    fun getUserPhoto(login: String): ByteArray?

    fun getShortProfile(principal: Principal): ShortProfileDto
}