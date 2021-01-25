package com.ikuzmin.cloud.publishing.model.entities

import com.ikuzmin.cloud.publishing.model.roles.EmployeeType
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
class Profile: Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var employeeLogin: String? = null

    @Column(nullable = false)
    var sex: Char? = null

    @Column(nullable = false)
    var birthDate: LocalDate? = null

    @Column(nullable = false)
    var address: String? = null

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var type: EmployeeType? = null

    @ManyToOne
    @JoinColumn(name = "education_id", nullable = true)
    var education: Education? = null

    @Column(nullable = false)
    var chiefEditor: Boolean? = null

}