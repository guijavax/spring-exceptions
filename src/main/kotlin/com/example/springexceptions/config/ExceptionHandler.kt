package com.example.springexceptions.config

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import javax.validation.ConstraintViolationException


@ControllerAdvice
class ExceptionHandler{

    @ExceptionHandler(value = [MethodArgumentNotValidException::class])
    fun constraintViolationException(ex : MethodArgumentNotValidException) : ResponseEntity<*>{
        val body = MontaListaErros.montaListaErrors(ex.bindingResult.fieldErrors, ex)
        return ResponseEntity.badRequest().body(body)
    }
}