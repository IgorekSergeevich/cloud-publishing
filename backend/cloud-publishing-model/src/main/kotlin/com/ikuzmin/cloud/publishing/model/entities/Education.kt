package com.ikuzmin.cloud.publishing.model.entities

import java.io.Serializable
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
class Education: Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Int? = null

    @Column(nullable = false)
    var title: String? = null

}