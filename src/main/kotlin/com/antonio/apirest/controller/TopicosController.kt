package com.antonio.apirest.controller

import com.antonio.apirest.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class TopicosController {

    @Autowired
    private val topicoRepository: TopicoRepository? = null

    @RequestMapping("/topicos")
    fun lista(): List<TopicoDto?>? {
        val topicos = topicoRepository!!.findAll()
        return TopicoDto.converter(topicos)
    }
}

