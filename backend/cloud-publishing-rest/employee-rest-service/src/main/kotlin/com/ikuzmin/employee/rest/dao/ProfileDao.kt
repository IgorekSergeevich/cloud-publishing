package com.ikuzmin.employee.rest.dao

import com.ikuzmin.cloud.publishing.model.entities.Profile
import org.springframework.data.jpa.repository.JpaRepository

interface ProfileDao: JpaRepository<Profile, String>