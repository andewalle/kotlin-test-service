package com.example.kotlintestservice.controller

import com.example.kotlintestservice.controller.requests.CreateUserRequest
import com.example.kotlintestservice.controller.requests.RemoveUserRequest
import com.example.kotlintestservice.controller.requests.UpdateUserRequest
import com.example.kotlintestservice.entity.User
import com.example.kotlintestservice.service.UserService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.net.http.HttpResponse

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService){

    @PostMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(
            value = "Create User")
    fun create(@RequestBody req: CreateUserRequest): User = userService.create(req)


    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = "Get User by id"
    )
    fun getById(@PathVariable("id") id:Long): User = userService.getByIdKtl(id)


    @PatchMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(
            value = "Update User"
    )
    fun updateById(@PathVariable("id") id: Long, @RequestBody req: UpdateUserRequest ):User =
            userService.updateUser(id, req)

//    @PatchMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
//    @ResponseStatus(HttpStatus.OK)
//    @ApiOperation(
//            value = "Remove User"
//    )
//    fun removeById(@PathVariable("id") id : Long, @RequestBody req: RemoveUserRequest ):User =
//            userService.removeUser(id, req)
}