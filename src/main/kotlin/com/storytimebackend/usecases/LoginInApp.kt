package com.storytimebackend.usecases

import com.storytimebackend.drivers.database.UserRepository
import com.storytimebackend.entities.User
import org.springframework.stereotype.Component

@Component
class LoginInApp(
    private val userRepository: UserRepository
) {

    fun searchIdInDatabase(email: String, password: String): User? {
        try {
            val user = userRepository.findByEmail(email)
            if (user.email == email && user.password == password) {
                return user
            }

        } catch (e: Throwable) {
            return null
        }

        return null
    }
}