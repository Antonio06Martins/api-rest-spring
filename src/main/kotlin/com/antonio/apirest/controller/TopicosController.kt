package com.antonio.apirest.controller

import com.antonio.apirest.modelo.Curso
import com.antonio.apirest.modelo.Topico
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TopicosController {

    @RequestMapping("/topicos")
    fun lista(): List<TopicoDto?>? {
        val topico = Topico("Duvida", "Duvida com Spring", Curso("Spring", "Programação"))
        return TopicoDto().converter(arrayListOf(topico, topico, topico))
    }
}