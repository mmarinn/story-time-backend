package com.storytimebackend.drivers.database

import com.storytimebackend.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, String> {
    fun findByEmail(email : String) : Optional<User>
}
