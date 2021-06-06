package com.antonio.apirest.controller.form

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

class LoginForm {
    var email: String? = null
    var senha: String? = null

    fun converter(): UsernamePasswordAuthenticationToken {
        return UsernamePasswordAuthenticationToken(email, senha)
    }
}