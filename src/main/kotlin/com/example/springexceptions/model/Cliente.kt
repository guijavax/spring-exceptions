package com.example.springexceptions.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.sun.istack.NotNull
import org.hibernate.validator.constraints.Length
import org.springframework.validation.annotation.Validated
import javax.persistence.Id
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Table
import javax.validation.Valid
import javax.validation.constraints.*

@Entity
@Table(name = "cliente")
@Validated
data class Cliente (

    @Id
    @GeneratedValue
    val idCliente: Long = 0L,

    @Column
    @JsonProperty(value = "nome_cliente")
    @field:NotEmpty(message = "{argumentos.nome}")
    val nomeCliente: String = "",

    @Column
    @field:Digits(integer = 3, message = "{argumentos.idade_invalida}", fraction = 0)
    @field:Max(value = 100, message = "{argumentos.tamanho_idade}")
    @field:Min(value = 18)
    val idade: Int = 0

)