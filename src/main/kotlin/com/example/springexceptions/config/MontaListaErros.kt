package com.example.springexceptions.config

import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException

class MontaListaErros {
    private constructor(){}

    companion object {
        fun montaListaErrors(errors: List<FieldError>, ex: MethodArgumentNotValidException) : MutableMap<String, MutableList<String?>> {
            val obj = mutableMapOf<String, MutableList<String?>>()
            var listaErros = mutableListOf<String?>()
            errors.forEach { error ->
                listaErros.add(error.defaultMessage)
            }
            obj.put("usuarios", listaErros)
            listaErros = mutableListOf()
            ex.bindingResult.allErrors.forEach{error ->
                listaErros.add(error.toString())
            }
            obj.put("desenvolvedores", listaErros)
            return obj
        }
    }
}