package com.example.springexceptions

import com.example.springexceptions.generic.RepositoryGeneric
import com.example.springexceptions.services.ClienteService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource

import org.springframework.context.MessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean







@Configuration
@ComponentScan(basePackageClasses = [ClienteService::class, RepositoryGeneric::class])
class Config {

    @Bean
    fun messageSource(): MessageSource? {
        return  ReloadableResourceBundleMessageSource().let {messageSource ->
            messageSource.setBasename("classpath:messages")
            messageSource.setDefaultEncoding("UTF-8")
            messageSource
        }
    }

    @Bean
    fun getValidator(): LocalValidatorFactoryBean? {
        return LocalValidatorFactoryBean().let { bean->
            bean.setValidationMessageSource(messageSource()!!)
            bean
        }
    }
}