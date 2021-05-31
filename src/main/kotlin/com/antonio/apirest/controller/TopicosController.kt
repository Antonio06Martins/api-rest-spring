package com.antonio.apirest.controller

import com.antonio.apirest.controller.dto.DetalhesDoTopicoDto
import com.antonio.apirest.controller.dto.TopicoDto
import com.antonio.apirest.controller.form.AtualizacaoTopicoForm
import com.antonio.apirest.controller.form.TopicoForm
import com.antonio.apirest.modelo.Topico
import com.antonio.apirest.repository.CursoRepository
import com.antonio.apirest.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import java.util.*
import javax.transaction.Transactional
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
    @Transactional
    fun cadastrar(@RequestBody @Valid form: TopicoForm, uriBuilder: UriComponentsBuilder): ResponseEntity<TopicoDto?>? {
        val topico = form.converter(cursoRepository!!)
        topicoRepository!!.save(topico)
        val uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.id).toUri()
        return ResponseEntity.created(uri).body(TopicoDto(topico))
    }

    @GetMapping("/{id}")
    fun detalhar(@PathVariable id: Long?): ResponseEntity<DetalhesDoTopicoDto?>? {
        val topico = topicoRepository!!.findById(id!!)
        return if (topico.isPresent) {
            ResponseEntity.ok(DetalhesDoTopicoDto(topico.get()))
        } else ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(
        @PathVariable id: Long?,
        @RequestBody form: @Valid AtualizacaoTopicoForm?
    ): ResponseEntity<TopicoDto?>? {
        val optional: Optional<Topico?> = topicoRepository!!.findById(id!!)
        if (optional.isPresent()) {
            val topico = form!!.atualizar(id, topicoRepository)
            return ResponseEntity.ok(TopicoDto(topico))
        }
        return ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    @Transactional
    fun remover(@PathVariable id: Long?): ResponseEntity<*>? {
        val optional: Optional<Topico?> = topicoRepository!!.findById(id!!)
        if (optional.isPresent()) {
            topicoRepository.deleteById(id)
            return ResponseEntity.ok().build<Any>()
        }
        return ResponseEntity.notFound().build<Any>()
    }
}

