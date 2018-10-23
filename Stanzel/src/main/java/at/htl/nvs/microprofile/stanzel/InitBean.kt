package at.htl.nvs.microprofile.stanzel

import at.htl.nvs.microprofile.stanzel.entity.Car
import at.htl.nvs.microprofile.stanzel.entity.Person
import at.htl.nvs.microprofile.stanzel.persistence.CarRepository
import at.htl.nvs.microprofile.stanzel.persistence.PersonRepository
import javax.annotation.PostConstruct
import javax.ejb.Singleton
import javax.ejb.Startup
import javax.inject.Inject

@Startup
@Singleton
open class InitBean {
    @Inject
    open lateinit var carRepository: CarRepository
    @Inject
    open lateinit var personRepository: PersonRepository

    @PostConstruct
    fun init() {
        val p1 = personRepository.create(Person(name = "Bürgi"))
        val p2 = personRepository.create(Person(name = "Bizi"))

        carRepository.create(Car(brand = "Audi", type = "A6", owner = p2))
        carRepository.create(Car(brand = "Audi", type = "RS8", owner = p2))
        carRepository.create(Car(brand = "Opel", type = "Corse", owner = p1))
    }

}