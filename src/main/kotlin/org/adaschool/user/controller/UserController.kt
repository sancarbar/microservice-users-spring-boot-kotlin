package org.adaschool.user.controller

import org.adaschool.user.controller.dto.UserDto
import org.adaschool.user.data.User
import org.adaschool.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("v1/user")
class UserController(@Autowired private val userService: UserService) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<User>? {
        val userOptional = userService.findById(id)
        if (userOptional.isPresent)
            return ResponseEntity.ok(userOptional.get())
        else
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User with Id $id not found")
    }

    @PostMapping
    fun create(@RequestBody userDto: UserDto): ResponseEntity<User> {
        val user = userService.createUser(User(userDto))
        return ResponseEntity.ok(user)
    }

    @GetMapping("/all")
    fun all(): ResponseEntity<Iterable<User>> {
        return ResponseEntity.ok(userService.all())
    }


}