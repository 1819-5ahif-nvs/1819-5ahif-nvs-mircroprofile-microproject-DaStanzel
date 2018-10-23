package at.htl.nvs.microprofile.stanzel.persistence

import at.htl.nvs.microprofile.stanzel.entity.Person
import javax.ejb.Stateless
import javax.enterprise.context.ApplicationScoped
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.transaction.Transactional

@ApplicationScoped
@Transactional
open class PersonRepository: Repository<Person> {
    @PersistenceContext
    private lateinit var entityManager: EntityManager

    override fun create(item: Person): Person {
        entityManager.persist(item)
        return item
    }

    override fun update(item: Person) {
        entityManager.merge(item)
    }

    override fun getAll(): List<Person> {
        return entityManager.createNamedQuery("Person.getAll", Person::class.java).resultList
    }

    override fun getById(id: Long): Person {
        return entityManager.find(Person::class.java, id)
    }

    override fun delete(id: Long) {
        entityManager.remove(id)
    }

}