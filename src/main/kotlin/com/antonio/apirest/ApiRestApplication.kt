package com.antonio.apirest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.web.config.EnableSpringDataWebSupport

@SpringBootApplication

//Anotação para utilizar a paginação automatica
@EnableSpringDataWebSupport

//Anotação para utilizar cache
@EnableCaching
class ApiRestApplication

fun main(args: Array<String>) {
	runApplication<ApiRestApplication>(*args)
}
