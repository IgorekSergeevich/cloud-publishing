package com.ikuzmin.cloud.publishing.model.entities

import com.ikuzmin.cloud.publishing.model.roles.EmployeeType
import java.io.Serializable
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
class Employee: Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int? = null

    @Column(unique = true)
    var login: String? = null

    @Column
    var firstName: String? = null

    @Column
    var lastName: String? = null

    @Column
    var middleName: String? = null

    @Column(nullable = false, unique = true)
    var email: String? = null

    @Column(nullable = false)
    val password: String? = null

    @Column(nullable = false)
    val sex: Char? = null

    @Column(nullable = false)
    val birthYear: Short? = null

    @Column(nullable = false)
    val address: String? = null

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val type: EmployeeType? = null

    @ManyToOne
    @JoinColumn(name = "education_id", nullable = true)
    val education: Education? = null

    @Column(nullable = false)
    val chiefEditor: Boolean? = null

}