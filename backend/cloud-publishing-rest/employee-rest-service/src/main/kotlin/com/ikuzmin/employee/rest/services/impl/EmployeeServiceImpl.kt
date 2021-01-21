package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser
import com.ikuzmin.common.rest.clients.KeycloakRestClient
import com.ikuzmin.employee.rest.dao.ProfileDao
import com.ikuzmin.employee.rest.services.EmployeeService
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import java.util.stream.Collectors.toList
import java.util.stream.Collectors.toMap


@Service
class EmployeeServiceImpl constructor(
    val profileDao: ProfileDao,
    val keycloakRestClient: KeycloakRestClient,
    val modelMapper: ModelMapper
) : EmployeeService {

    override fun getAllEmployee(): List<Profile> = profileDao.findAll()

    override fun getEmployeesProfiles(): List<ProfileDto> {
        val keycloakUsers = keycloakRestClient.getUsers()?.body?.toList()
        val profilesMap = profileDao.findAll()
            .stream()
            .collect(
                toMap(Profile::employeeLogin) { profile -> profile })

        return keycloakUsers
            ?.stream()
            ?.map { user ->
                val dto = modelMapper.map(user, ProfileDto::class.java)
                val profile = profilesMap[user.username]
                if (profile != null) modelMapper.map(profile, dto)
                return@map dto
            }?.collect(toList())?: emptyList()
    }

    override fun createEmployee(keycloakUser: KeycloakUser) {
        keycloakRestClient.createEmployeeAccount(keycloakUser)
    }

}