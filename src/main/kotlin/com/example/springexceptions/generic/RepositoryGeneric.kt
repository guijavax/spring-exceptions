package com.example.springexceptions.generic

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.NoRepositoryBean
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.persistence.Query

@Repository
@Transactional
class RepositoryGeneric<T> {

    @PersistenceContext
    lateinit var entityManager: EntityManager

    fun save(t : T) {
        entityManager.persist(t)
    }

    fun findById(classe: Class<T>,id : Long) : T = entityManager.find(classe, id)

    fun findAll() : MutableList<*>? = entityManager.createNativeQuery("SELECT * FROM cliente").resultList

    fun saveAndFlush(t: T) {
        entityManager.merge(t)
    }

    fun deleteById(id: Long) {
       val query =  entityManager.createQuery("delete from Cliente c where c.id = :id")
        query.setParameter("id", id).executeUpdate()
    }
}