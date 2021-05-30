package com.antonio.apirest.repository

import com.antonio.apirest.modelo.Topico
import org.springframework.data.jpa.repository.JpaRepository


interface TopicoRepository: JpaRepository<Topico?, Long?> {
}
