package com.example.kotlintestservice.repository

import com.example.kotlintestservice.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByName(name: String): User?

}
