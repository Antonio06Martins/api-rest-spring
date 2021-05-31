package com.antonio.apirest.controller.form

import com.antonio.apirest.modelo.Topico

import com.antonio.apirest.repository.TopicoRepository
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


class AtualizacaoTopicoForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    var titulo: String? = null

    @NotNull
    @NotEmpty
    @Length(min = 10)
    var mensagem: String? = null

    fun atualizar(id: Long, topicoRepository: TopicoRepository): Topico {
        val topico = topicoRepository.getById(id)
        topico.titulo = titulo
        topico.mensagem = mensagem
        return topico
    }
}
