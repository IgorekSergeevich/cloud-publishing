package com.ikuzmin.cloud.publishing.model.entities

import javax.persistence.*

@Entity
@Table(name ="photos")
class Photo {

    @Id
    var employeeLogin: String? = null

    @Column
    var photo: ByteArray? = null

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_login")
    var profile: Profile? = null

}