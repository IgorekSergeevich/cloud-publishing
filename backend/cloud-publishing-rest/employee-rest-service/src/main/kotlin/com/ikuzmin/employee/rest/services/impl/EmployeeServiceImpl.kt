package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Education
import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser
import com.ikuzmin.common.rest.clients.KeycloakRestClient
import com.ikuzmin.employee.rest.dao.EducationDao
import com.ikuzmin.employee.rest.dao.ProfileDao
import com.ikuzmin.employee.rest.mappers.UserAndProfileMapper
import com.ikuzmin.employee.rest.services.EmployeeService
import org.springframework.stereotype.Service
import java.util.stream.Collectors.toList
import java.util.stream.Collectors.toMap


@Service
class EmployeeServiceImpl constructor(
    val profileDao: ProfileDao,
    val keycloakRestClient: KeycloakRestClient,
    val userAndProfileMapper: UserAndProfileMapper,
    val educationDao: EducationDao
) : EmployeeService {

    override fun getEmployeesProfiles(): List<ProfileDto> {
        val keycloakUsers = keycloakRestClient.getUsers()?.body?.toList()
        val profilesMap = profileDao.findAll()
            .stream()
            .collect(
                toMap(Profile::employeeLogin) { profile -> profile })

        return keycloakUsers
            ?.stream()
            ?.map { user ->
                userAndProfileMapper
                    .convertUserAndProfileToDto(
                        user,
                        profilesMap[user.username]
                    )
            }?.collect(toList()) ?: emptyList()
    }

    override fun createEmployee(userProfile: ProfileDto) {
        keycloakRestClient.createEmployeeAccount(
            userAndProfileMapper.convertDtoToUser(userProfile))
        profileDao.save(
            userAndProfileMapper.convertDtoToProfile(userProfile))
    }

    override fun getEducationList(): List<Education> = educationDao.findAll()

}