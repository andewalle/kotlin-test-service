package com.example.kotlintestservice.service

import com.example.kotlintestservice.requests.CreateUserRequest
import com.example.kotlintestservice.requests.UpdateUserRequest
import com.example.kotlintestservice.entity.User
import com.example.kotlintestservice.exceptions.UserAlreadyExistsException
import com.example.kotlintestservice.repository.UserRepository
import com.example.kotlintestservice.requests.RemoveUserRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono


@Service
class UserServiceImpl (private val userRepository: UserRepository): UserService{

    override fun create(req: CreateUserRequest): User {
        return userRepository.findByName(req.name)?.let {
            throw UserAlreadyExistsException("A user with name: ${req.name} already exists")
        }?: userRepository.save(User(req.name, req.last))
    }

    override fun getById(id: Long): Mono<User> {
        return userRepository.findByIdOrNull(id)?.let {
            Mono.just(it)

        }?: throw UserAlreadyExistsException("A user with id : ${id} can not be found")
    }

    override fun getByIdKtl(id: Long): User {
        return userRepository.findByIdOrNull(id)?.let {
            it
        }?:throw UserAlreadyExistsException("A user with id : ${id} can not be found")

    }

    override fun getByIdOptional(id: Long): User {
        return userRepository.findById(id)?.orElseThrow {
            throw UserAlreadyExistsException("A user with id: ${id} can not be found")

        }
    }

    override fun updateUser(id: Long, req: UpdateUserRequest): User {
        return userRepository.findByIdOrNull(id)?.let {user ->
            user.name = req.name
            userRepository.save(user)
        }?: throw UserAlreadyExistsException("Could not update user")
    }

    override fun removeUser(id: Long) {
        return userRepository.deleteById(id)?.let{
            throw UserAlreadyExistsException("Can not remove user")

        }
    }

}