package com.antonio.apirest.repository

import com.antonio.apirest.modelo.Curso
import org.springframework.data.jpa.repository.JpaRepository


interface CursoRepository : JpaRepository<Curso?, Long?> {
    fun findByNome(nome: String?): Curso?
}