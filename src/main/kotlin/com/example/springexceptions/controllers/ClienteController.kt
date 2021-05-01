package com.example.springexceptions.controllers

import com.example.springexceptions.model.Cliente
import com.example.springexceptions.services.ClienteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.websocket.server.PathParam


@RestController
@RequestMapping("/cliente")
class ClienteController {

    private lateinit var service : ClienteService

    @Autowired
    constructor(service: ClienteService) {
        this.service = service
    }

    @RequestMapping(value = ["/{id}"],method = [RequestMethod.GET])
    fun getClienteById(@PathVariable("id") idCliente : Long) : ResponseEntity<Any>{
        val cliente = service.findClienteById(idCliente)
        return if(cliente  != null) ResponseEntity.ok(cliente) else ResponseEntity.noContent().build()
    }

    @RequestMapping(method = [RequestMethod.POST])
    fun insertCliente(@Valid @RequestBody cliente : Cliente) : ResponseEntity<Cliente> {
        service.insere(cliente)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @RequestMapping(method = [RequestMethod.GET])
    fun getClientes() : ResponseEntity<Any>{
        val clientes = service.findAllClientes()
        return if(clientes?.let { it.isNotEmpty()} == true){
            ResponseEntity.ok(clientes)
        } else {
            ResponseEntity.noContent().build()
        }
    }

    @RequestMapping(method = [RequestMethod.PATCH])
    fun updateCliente(@RequestBody cliente : Cliente) : ResponseEntity<Cliente> {
        service.changeCliente(cliente)
        return ResponseEntity.status(HttpStatus.OK).build()
    }
//
    @RequestMapping(value = ["/{id}"],method = [RequestMethod.DELETE])
    fun deleteClienteById(@PathVariable("id") idCliente : Long) : ResponseEntity<Any>{
        service.deleteCliente(idCliente)
        return ResponseEntity.noContent().build()
    }
}