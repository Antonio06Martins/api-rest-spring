package com.antonio.apirest.config.security

import com.antonio.apirest.modelo.Usuario
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.util.*

@Service
class TokenService {
    @Value("\${forum.jwt.expiration}")
    private val expiration: String? = null

    @Value("\${forum.jwt.secret}")
    private val secret: String? = null
    fun gerarToken(authentication: Authentication): String {
        val logado = authentication.principal as Usuario
        val hoje = Date()
        val dataExpiracao = Date(hoje.time + expiration!!.toLong())
        return Jwts.builder()
            .setIssuer("API do Fórum da Alura")
            .setSubject(logado.getId().toString())
            .setIssuedAt(hoje)
            .setExpiration(dataExpiracao)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact()
    }

    fun isTokenValido(token: String?): Boolean {
        return try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun getIdUsuario(token: String?): Long {
        val claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).body
        return claims.subject.toLong()
    }
}
