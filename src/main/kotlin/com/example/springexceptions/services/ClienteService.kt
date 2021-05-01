package com.example.springexceptions.services

import com.example.springexceptions.generic.RepositoryGeneric
import com.example.springexceptions.model.Cliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ClienteService {

    @Autowired
    lateinit var repository : RepositoryGeneric<Cliente>

    private val classe = Cliente::class.java

//
    fun findClienteById(id: Long) = repository.findById(classe, id)
    //
    fun findAllClientes() = repository.findAll()
//
    fun changeCliente(cliente: Cliente){
        repository.saveAndFlush(cliente)
    }
//
    fun deleteCliente(id: Long) { repository.deleteById(id) }
    fun insere(cliente: Cliente) {
        repository.save(cliente)
    }
}