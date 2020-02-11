package com.example.kotlintestservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinTestServiceApplication

fun main(args: Array<String>) {
    runApplication<KotlinTestServiceApplication>(*args)
}
