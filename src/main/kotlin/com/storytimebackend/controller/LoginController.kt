package com.storytimebackend.controller

import com.storytimebackend.usecases.LoginInApp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class LoginController {

    @Autowired
    lateinit var loginInApp: LoginInApp

    @GetMapping("/user")
    fun loginInApp(@RequestParam email: String, @RequestParam password: String): ResponseEntity<String> {

        val user = loginInApp.searchIdInDatabase(email, password)
        if(user == null)  {
         return ResponseEntity(HttpStatus.NOT_FOUND)
        }

        return ResponseEntity(user.fullName, HttpStatus.OK)
    }
}