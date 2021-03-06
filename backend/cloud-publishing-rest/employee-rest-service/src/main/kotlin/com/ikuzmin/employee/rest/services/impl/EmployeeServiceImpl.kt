package com.ikuzmin.employee.rest.services.impl

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.dto.ShortProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Education
import com.ikuzmin.cloud.publishing.model.entities.Profile
import com.ikuzmin.common.rest.clients.KeycloakRestClient
import com.ikuzmin.employee.rest.dao.EducationDao
import com.ikuzmin.employee.rest.dao.PhotoDao
import com.ikuzmin.employee.rest.dao.ProfileDao
import com.ikuzmin.employee.rest.mappers.ProfileToShortProfileMapper
import com.ikuzmin.employee.rest.mappers.UserAndProfileMapper
import com.ikuzmin.employee.rest.services.EmployeeService
import com.ikuzmin.employee.rest.services.MailService
import org.keycloak.KeycloakPrincipal
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken
import org.springframework.stereotype.Service
import java.security.Principal
import java.util.stream.Collectors.toList
import java.util.stream.Collectors.toMap


@Service
class EmployeeServiceImpl constructor(
    val profileDao: ProfileDao,
    val keycloakRestClient: KeycloakRestClient,
    val userAndProfileMapper: UserAndProfileMapper,
    val shortProfileMapper: ProfileToShortProfileMapper,
    val educationDao: EducationDao,
    val photoDao: PhotoDao,
    val mailService: MailService,
    val keycloakServiceClient: KeycloakServiceClient
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
        keycloakServiceClient.createUser(userProfile)
    }

    override fun getEducationList(): List<Education> = educationDao.findAll()

    override fun getShortProfile(principal: Principal): ShortProfileDto {
        val login = ((principal as KeycloakAuthenticationToken)
            .principal as KeycloakPrincipal<*>)
            .keycloakSecurityContext
            .token
            .preferredUsername

        val profile = profileDao.findById(login).get()
        val dto = shortProfileMapper.profileToShortProfile(profile)
        if (photoDao.existsById(login)) {
            dto.profilePhotoUrl = "http://localhost:8080/employee/photo/$login"
        }
        return dto
    }

    override fun getUserPhoto(login: String): ByteArray? {
        val photo = photoDao.findById(login)
        return photo.get().photo
    }

}