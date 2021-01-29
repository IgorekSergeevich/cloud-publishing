package com.ikuzmin.employee.rest.dao

import com.ikuzmin.cloud.publishing.model.entities.Photo
import org.springframework.data.jpa.repository.JpaRepository

interface PhotoDao : JpaRepository<Photo, String>