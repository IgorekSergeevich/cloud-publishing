package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Education
import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser.Credential
import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.common.rest.clients.KeycloakRestClient
import com.ikuzmin.employee.rest.dao.EducationDao
import com.ikuzmin.employee.rest.dao.ProfileDao
import com.ikuzmin.employee.rest.mappers.UserAndProfileMapper
import com.ikuzmin.employee.rest.services.EmployeeService
import com.ikuzmin.employee.rest.services.MailService
import com.ikuzmin.employee.rest.services.PasswordGeneratorService
import org.springframework.stereotype.Service
import java.util.stream.Collectors.toList
import java.util.stream.Collectors.toMap


@Service
class EmployeeServiceImpl constructor(
    val profileDao: ProfileDao,
    val keycloakRestClient: KeycloakRestClient,
    val userAndProfileMapper: UserAndProfileMapper,
    val educationDao: EducationDao,
    val passwordGeneratorService: PasswordGeneratorService,
    val mailService: MailService
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
        val password = passwordGeneratorService.generatePassword()

        val keycloakUser = userAndProfileMapper.convertDtoToUser(userProfile)
        keycloakUser.credentials = listOf(
            Credential("password", password))

        keycloakRestClient.createEmployeeAccount(keycloakUser)
        profileDao.save(
            userAndProfileMapper.convertDtoToProfile(userProfile))


        mailService.sendGeneratedPassword(password)
    }

    override fun getEducationList(): List<Education> = educationDao.findAll()

    override fun getUserPhoto(userId: Int): ByteArray? {
        val profile = profileDao.findById(userId)
        return if (profile.isPresent) profile.get().photo else null
    }

}