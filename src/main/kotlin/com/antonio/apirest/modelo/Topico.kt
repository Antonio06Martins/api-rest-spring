package com.antonio.apirest.modelo

import java.time.LocalDateTime


class Topico(var titulo: String, var mensagem: String, var curso: Curso) {
    var id: Long? = null
    var dataCriacao = LocalDateTime.now()
    var status: StatusTopico = StatusTopico.NAO_RESPONDIDO
    var autor: Usuario? = null
    var respostas: List<Resposta> = ArrayList()

    override fun hashCode(): Int {
        val prime = 31
        var result = 1
        result = prime * result + if (id == null) 0 else id.hashCode()
        return result
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) return true
        if (obj == null) return false
        if (javaClass != obj.javaClass) return false
        val other = obj as Topico
        if (id == null) {
            if (other.id != null) return false
        } else if (id != other.id) return false
        return true
    }

}
