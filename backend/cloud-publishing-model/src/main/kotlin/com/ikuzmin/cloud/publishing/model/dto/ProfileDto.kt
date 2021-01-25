package com.ikuzmin.cloud.publishing.model.dto

import com.fasterxml.jackson.annotation.JsonGetter
import com.fasterxml.jackson.annotation.JsonSetter
import com.ikuzmin.cloud.publishing.model.roles.EmployeeType
import java.time.LocalDate


class ProfileDto {

    var username: String? = null

    var firstName: String? = null

    var lastName: String? = null

    var email: String? = null

    var sex: Char? = null

    var birthDate: LocalDate? = null

    var address: String? = null

    var type: EmployeeType? = null

    var educationId: Int? = null

    var chiefEditor: Boolean? = null

    @JsonGetter("type")
    fun getEmployeeTypeJson() = type?.type

    @JsonSetter("type")
    fun setEmployeeTypeJson(jsonType: String) {
        type = EmployeeType.getByType(jsonType)
    }
}