package com.ikuzmin.cloud.publishing.model.entities

import java.io.Serializable
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
class Education: Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Int? = null

    @Column
    val title: String? = null

    @OneToMany(mappedBy = "education")
    val employees: List<Profile>? = null

}