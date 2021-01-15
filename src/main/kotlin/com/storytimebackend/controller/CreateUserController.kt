package com.storytimebackend.controller

import com.storytimebackend.entities.User
import com.storytimebackend.usecases.CreateUser
import com.storytimebackend.usecases.UserAlreadyCreatedException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateUserController {

    private val logger = LoggerFactory.getLogger(CreateUserController::class.java)

    @Autowired
    lateinit var createUser: CreateUser

    @PostMapping("/user")
    fun createNewUser(@RequestBody user: User): ResponseEntity<String> {
        try {
            createUser.createNewUser(user)

        } catch (e: Throwable) {
            if (e is UserAlreadyCreatedException) {
                logger.info("User with email ${user.email} already created")
                return ResponseEntity(HttpStatus.CONFLICT)
            }

            logger.info("Error, we cannot create your user")
            return ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR)
        }
        logger.info("User with email ${user.email} created")
        return ResponseEntity(HttpStatus.OK)
    }

}