package com.antonio.apirest.controller

import com.antonio.apirest.modelo.Topico
import java.time.LocalDateTime
import java.util.stream.Collectors


class TopicoDto(topico: Topico) {
    val id: Long?
    val titulo: String
    val mensagem: String
    val dataCriacao: LocalDateTime

    companion object {
        fun converter(topicos: List<Topico?>): List<TopicoDto> {
            return topicos.stream().map { topico: Topico? ->
                TopicoDto(
                    topico!!
                )
            }.collect(Collectors.toList())
        }
    }

    init {
        id = topico.id
        titulo = topico.titulo
        mensagem = topico.mensagem
        dataCriacao = topico.dataCriacao
    }
}

