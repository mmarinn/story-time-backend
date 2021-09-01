package com.storytimebackend.usecases.user

import com.storytimebackend.drivers.database.UserRepository
import com.storytimebackend.entities.User
import org.springframework.stereotype.Component
import java.util.*
import kotlin.jvm.Throws

@Component
class LoginInApp(
    private val userRepository: UserRepository
) {

    @Throws(RuntimeException::class)
    fun retrieveFromDatabase(emailToLogin: String, passwordToLogin: String): Optional<User> {
        return userRepository.findByEmail(emailToLogin)

    }
}