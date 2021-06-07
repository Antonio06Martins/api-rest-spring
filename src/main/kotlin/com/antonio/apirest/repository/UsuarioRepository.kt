package com.antonio.apirest.repository

import com.antonio.apirest.modelo.Usuario

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface UsuarioRepository : JpaRepository<Usuario?, Long?> {
    fun findByEmail(email: String?): Optional<Usuario?>?
}