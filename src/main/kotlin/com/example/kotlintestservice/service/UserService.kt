package com.example.kotlintestservice.service

import com.example.kotlintestservice.controller.requests.CreateUserRequest
import com.example.kotlintestservice.controller.requests.RemoveUserRequest
import com.example.kotlintestservice.controller.requests.UpdateUserRequest
import com.example.kotlintestservice.entity.User
import reactor.core.publisher.Mono

interface UserService {

    fun create(req: CreateUserRequest): User
    fun getById(id: Long): Mono<User>
    fun getByIdKtl(id: Long): User
    fun getByIdOptional(id: Long): User
    fun updateUser(id: Long, req: UpdateUserRequest): User
//    fun removeUser(id: Long, req: RemoveUserRequest): User


}
