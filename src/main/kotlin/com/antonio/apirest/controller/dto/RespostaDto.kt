package com.antonio.apirest.controller.dto

import com.antonio.apirest.modelo.Resposta
import java.time.LocalDateTime


class RespostaDto(resposta: Resposta) {
    val id: Long?
    val mensagem: String?
    val dataCriacao: LocalDateTime
    val nomeAutor: String?

    init {
        id = resposta.id
        mensagem = resposta.mensagem
        dataCriacao = resposta.dataCriacao
        nomeAutor = resposta.autor!!.nome
    }
}