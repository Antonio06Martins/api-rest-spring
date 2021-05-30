package com.antonio.apirest.controller

import com.antonio.apirest.controller.dto.TopicoDto
import com.antonio.apirest.controller.form.TopicoForm
import com.antonio.apirest.repository.CursoRepository
import com.antonio.apirest.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("/topicos")
class TopicosController {

    @Autowired
    private val topicoRepository: TopicoRepository? = null

    @Autowired
    private val cursoRepository: CursoRepository? = null

    @GetMapping
    fun lista(nomeCurso: String?): List<TopicoDto?>? {
        return if (nomeCurso == null){
            val topicos = topicoRepository!!.findAll()
            println(nomeCurso)
            TopicoDto.converter(topicos)
        } else {
            val topicos = topicoRepository!!.findByCursoNome(nomeCurso)
            println(nomeCurso)
            TopicoDto.converter(topicos)
        }
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid form: TopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoDto?>? {
        val topico = form.converter(cursoRepository!!)
        topicoRepository!!.save(topico)
        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id).toUri()
        return ResponseEntity.created(uri).body(TopicoDto(topico))
    }
}

