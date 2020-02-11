package com.example.kotlintestservice.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException


@ResponseStatus(HttpStatus.CONFLICT)
class UserAlreadyExistsException(override val message: String?) : RuntimeException(message){

}
