package com.ikuzmin.employee.rest.mappers

import com.ikuzmin.cloud.publishing.model.dto.ProfileDto
import com.ikuzmin.cloud.publishing.model.entities.KeycloakUser
import com.ikuzmin.cloud.publishing.model.entities.Profile
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.Mappings

@Mapper(componentModel = "spring")
interface UserAndProfileMapper {

    @Mapping(source = "profile.education.id", target = "educationId")
    fun convertUserAndProfileToDto(user: KeycloakUser, profile: Profile?): ProfileDto

    fun convertDtoToUser(profileDto: ProfileDto): KeycloakUser

    @Mappings(value = [
        Mapping(source = "profileDto.educationId", target = "education.id"),
        Mapping(source = "profileDto.username", target = "employeeLogin")
    ])
    fun convertDtoToProfile(profileDto: ProfileDto): Profile

}