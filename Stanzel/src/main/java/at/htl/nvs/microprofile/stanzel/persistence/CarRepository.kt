package at.htl.nvs.microprofile.stanzel.persistence

import at.htl.nvs.microprofile.stanzel.entity.Car
import javax.ejb.Stateless
import javax.enterprise.context.ApplicationScoped
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@ApplicationScoped
@Transactional
open class CarRepository: Repository<Car> {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun create(item: Car): Car {
        entityManager.persist(item)
        return item
    }

    override fun update(item: Car) {
        entityManager.merge(item)
    }

    override fun getAll(): List<Car> {
        return entityManager.createNamedQuery("Car.getAll", Car::class.java).resultList
    }

    override fun getById(id: Long): Car {
        return entityManager.find(Car::class.java, id)
    }

    override fun delete(id: Long) {
        entityManager.remove(id)
    }

}