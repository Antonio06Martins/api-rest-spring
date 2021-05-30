package com.antonio.apirest.controller.form

import com.antonio.apirest.modelo.Curso
import com.antonio.apirest.modelo.Topico
import com.antonio.apirest.repository.CursoRepository
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

class TopicoForm {
    @NotNull @NotEmpty @Length(min = 5)
    var titulo: String? = null
    @NotNull @NotEmpty @Length(min = 10)
    var mensagem: String? = null
    @NotNull @NotEmpty
    var nomeCurso: String? = null

    fun converter(cursoRepository: CursoRepository): Topico {
        val curso: Curso? = cursoRepository.findByNome(nomeCurso)
        return Topico(titulo!!, mensagem!!, curso!!)
    }
}



