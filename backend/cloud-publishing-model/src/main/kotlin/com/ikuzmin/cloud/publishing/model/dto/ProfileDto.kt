package com.ikuzmin.cloud.publishing.model.dto

import com.ikuzmin.cloud.publishing.model.entities.Education
import com.ikuzmin.cloud.publishing.model.roles.EmployeeType


class ProfileDto {

    var username: String? = null

    var firstName: String? = null

    var lastName: String? = null

    var email: String? = null

    var sex: Char? = null

    var birthYear: Short? = null

    var address: String? = null

    var type: EmployeeType? = null

    var education: Education? = null

    var chiefEditor: Boolean? = null
}