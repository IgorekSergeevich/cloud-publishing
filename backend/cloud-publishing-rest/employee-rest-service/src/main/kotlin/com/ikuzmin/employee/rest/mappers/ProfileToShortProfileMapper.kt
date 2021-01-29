package com.ikuzmin.employee.rest.mappers

import com.ikuzmin.cloud.publishing.model.dto.ShortProfileDto
import com.ikuzmin.cloud.publishing.model.entities.Profile
import org.mapstruct.Mapper


@Mapper(componentModel = "spring")
interface ProfileToShortProfileMapper {

    fun profileToShortProfile(profile: Profile): ShortProfileDto
}