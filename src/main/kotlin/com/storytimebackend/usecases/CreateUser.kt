package com.storytimebackend.usecases

import com.storytimebackend.drivers.database.UserRepository
import com.storytimebackend.entities.User
import org.springframework.stereotype.Component

@Component
class CreateUser(
    private val userRepository: UserRepository
) {

    fun createUser(user: User) {
        try {
            val findByEmail = userRepository.findByEmail(user.email)

        } catch (e: Throwable) {
            userRepository.save(user)

        }
    }
}