package com.antonio.apirest.controller.dto

import com.antonio.apirest.modelo.Topico
import org.springframework.data.domain.Page
import java.time.LocalDateTime


class TopicoDto(topico: Topico) {
    val id: Long?
    val titulo: String
    val mensagem: String
    val dataCriacao: LocalDateTime

    companion object {
        fun converter(topicos: Page<Topico?>): Page<TopicoDto>? {
            return topicos.map { topico: Topico? -> TopicoDto(topico!!) }
        }
    }

    init {
        id = topico.id
        titulo = topico.titulo.toString()
        mensagem = topico.mensagem.toString()
        dataCriacao = topico.dataCriacao
    }
}



