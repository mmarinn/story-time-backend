package com.storytimebackend.controller

import com.storytimebackend.entities.User
import com.storytimebackend.usecases.CreateUser
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CreateUserController {

    @Autowired
    lateinit var createUser: CreateUser

    @PostMapping("/user")
    fun createNewUser(@RequestBody user: User) : ResponseEntity<String> {
        createUser.createUser(user)
        return ResponseEntity("User Created", HttpStatus.OK)
    }

}