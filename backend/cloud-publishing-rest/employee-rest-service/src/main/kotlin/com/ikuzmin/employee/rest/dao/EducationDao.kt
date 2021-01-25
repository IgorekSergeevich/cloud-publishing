package com.ikuzmin.employee.rest.dao

import com.ikuzmin.cloud.publishing.model.entities.Education
import org.springframework.data.jpa.repository.JpaRepository

interface EducationDao : JpaRepository<Education, Int>