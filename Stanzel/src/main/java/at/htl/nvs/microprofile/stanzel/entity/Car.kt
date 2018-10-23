package at.htl.nvs.microprofile.stanzel.entity

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@NamedQuery(name = "Car.getAll", query = "SELECT c FROM Car c")
data class Car (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,
        var brand: String? = null,
        var type: String? = null,
        @JoinColumn(name = "OWNER")
        @ManyToOne
        var owner: Person? = null
)