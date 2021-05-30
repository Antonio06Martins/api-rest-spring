package com.antonio.apirest.modelo

import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Topico(var titulo: String,
             var mensagem: String,

             @ManyToOne
             var curso: Curso) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var dataCriacao = LocalDateTime.now()

    @Enumerated(EnumType.STRING)
    var status: StatusTopico = StatusTopico.NAO_RESPONDIDO

    @ManyToOne
    var autor: Usuario? = null

    @ManyToMany(mappedBy = "topico")
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
