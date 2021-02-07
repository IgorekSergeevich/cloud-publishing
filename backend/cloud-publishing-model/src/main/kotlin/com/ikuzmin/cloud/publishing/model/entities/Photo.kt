package com.ikuzmin.cloud.publishing.model.entities

import javax.persistence.*

@Entity
class Photo {

    @Id
    @Column(length = 20)
    var employeeLogin: String? = null

    @Column(columnDefinition = "MEDIUMBLOB")
    var photo: ByteArray? = null

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_login")
    var profile: Profile? = null

}