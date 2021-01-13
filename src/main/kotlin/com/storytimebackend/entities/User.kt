package com.storytimebackend.entities

import java.sql.Timestamp
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "Appuser")
data class User(
    @Column
    val fullName: String,
    @Column
    val bornDate: Timestamp,
    @Id
    val email: String,
    @Column
    val password: String
)
