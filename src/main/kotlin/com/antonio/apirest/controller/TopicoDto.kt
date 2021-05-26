package com.antonio.apirest.controller

import com.antonio.apirest.modelo.Topico
import java.time.LocalDateTime
import java.util.function.Function
import java.util.stream.Collectors


class TopicoDto(topico: Topico) {
    val id: Long?
    val titulo: String
    val mensagem: String
    val dataCriacao: LocalDateTime

    init {
        id = topico.id
        titulo = topico.titulo
        mensagem = topico.mensagem
        dataCriacao = topico.dataCriacao
    }

    fun converter(topicos: List<Topico?>): List<TopicoDto?>? {
        return topicos.stream().map(Function { TopicoDto() }).collect(Collectors.toList())
    }
}

