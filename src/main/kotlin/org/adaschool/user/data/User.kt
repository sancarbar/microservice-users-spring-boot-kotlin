package org.adaschool.user.data

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "users")
data class User(
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id var id: Long?,
    var name: String,
    var email: String,
    var created: Date
) {

    constructor() : this(null, "", "", Date())


}
