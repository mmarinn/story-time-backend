package com.storytimebackend.usecases.user

import com.storytimebackend.drivers.database.UserRepository
import com.storytimebackend.entities.User
import org.springframework.stereotype.Component

@Component
class CreateUser(
    private val userRepository: UserRepository
) {

    @Throws(RuntimeException::class)
    fun createNewUser(userToCreate: User) {

        if (userExists(userToCreate)) {
            throw UserAlreadyCreatedException("User with email ${userToCreate.email} already created")
        }
        userRepository.save(userToCreate)
    }

    @Throws(RuntimeException::class)
    fun userExists(user: User): Boolean {
        val userFromDatabase = userRepository.findByEmail(user.email)
        return userFromDatabase.isPresent
    }
}