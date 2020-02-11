package com.example.kotlintestservice.entity

import org.springframework.data.annotation.Id
import javax.persistence.*


@Entity
@Table(name = "User")
data class User(

    var name:String? = null,
    @GeneratedValue(strategy = GenerationType.AUTO) val id: Long = 0

)

