package com.antonio.apirest.controller.dto

import com.antonio.apirest.modelo.Resposta
import com.antonio.apirest.modelo.StatusTopico
import com.antonio.apirest.modelo.Topico
import java.time.LocalDateTime
import java.util.stream.Collectors


class DetalhesDoTopicoDto(topico: Topico) {
    val id: Long?
    val titulo: String?
    val mensagem: String?
    val dataCriacao: LocalDateTime
    val nomeAutor: String?
    val status: StatusTopico
    private val respostas: MutableList<RespostaDto>
    fun getRespostas(): List<RespostaDto> {
        return respostas
    }

    init {
        id = topico.id
        titulo = topico.titulo
        mensagem = topico.mensagem
        dataCriacao = topico.dataCriacao
        nomeAutor = topico.autor!!.nome
        status = topico.status
        respostas = ArrayList()
        respostas.addAll(topico.respostas.stream().map { resposta: Resposta? ->
            RespostaDto(
                resposta!!
            )
        }.collect(Collectors.toList()))
    }
}
