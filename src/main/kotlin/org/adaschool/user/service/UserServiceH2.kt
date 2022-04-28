package org.adaschool.user.service

import org.adaschool.user.data.User
import org.adaschool.user.data.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceH2(@Autowired private val userDao: UserDao) : UserService {

    override fun findById(id: Long): Optional<User> {
        return userDao.findById(id)
    }

    override fun createUser(user: User): User {
        return userDao.save(user)
    }

    override fun all(): Iterable<User> {
        return userDao.findAll()
    }
}