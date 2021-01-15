package com.storytimebackend.usecases

class UserAlreadyCreatedException(override val message : String) : RuntimeException()