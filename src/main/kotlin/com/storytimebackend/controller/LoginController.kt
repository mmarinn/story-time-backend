package com.storytimebackend.controller

import com.storytimebackend.entities.User
import com.storytimebackend.usecases.LoginInApp
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {

    private val logger = LoggerFactory.getLogger(LoginController::class.java)

    @Autowired
    lateinit var loginInApp: LoginInApp

    @GetMapping("/user")
    fun loginInApp(@RequestParam email: String, @RequestParam password: String): ResponseEntity<LoginResponse> {

        try {
            val userOptional = loginInApp.retrieveFromDatabase(email, password)
            val user = userOptional.get()
            if (checkCredentials(user, email, password)) {
                return ResponseEntity(LoginResponse(user.fullName), HttpStatus.OK)

            }
            logger.info("User with $email not autorized")
            return ResponseEntity(HttpStatus.UNAUTHORIZED)

        } catch (e: Throwable) {
            logger.info("User with email $email not found")
            return ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    private fun checkCredentials(
        user: User,
        emailToLogin: String,
        passwordToLogin: String
    ) = user.email == emailToLogin && user.password == passwordToLogin
}