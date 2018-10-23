package at.htl.nvs.microprofile.stanzel.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@NamedQuery(name = "Person.getAll", query = "SELECT p FROM Person p")
data class Person (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var name: String? = null
)