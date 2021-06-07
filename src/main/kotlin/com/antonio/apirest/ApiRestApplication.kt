package com.antonio.apirest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.data.web.config.EnableSpringDataWebSupport
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication

//Anotação para utilizar a paginação automatica
@EnableSpringDataWebSupport

//Anotação para utilizar cache
@EnableCaching

//Anotação para swagger
@EnableSwagger2
class ApiRestApplication

fun main(args: Array<String>) {
	runApplication<ApiRestApplication>(*args)
}
