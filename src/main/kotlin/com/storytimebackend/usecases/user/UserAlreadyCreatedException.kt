package com.storytimebackend.usecases.user

class UserAlreadyCreatedException(override val message : String) : RuntimeException()