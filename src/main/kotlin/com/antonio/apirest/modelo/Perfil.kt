package com.antonio.apirest.modelo

import org.springframework.security.core.GrantedAuthority
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class Perfil : GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var nome: String? = null

    override fun getAuthority(): String {
        return nome!!
    }

    companion object {
        private const val serialVersionUID = 1L
    }
}