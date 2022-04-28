package org.adaschool.user.service

import org.adaschool.user.data.User
import java.util.*

interface UserService {

    fun findById(id: Long): Optional<User>

    fun createUser(user: User): User

    fun all(): Iterable<User>

}