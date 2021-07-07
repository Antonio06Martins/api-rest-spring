package com.antonio.apirest.repository

import com.antonio.apirest.modelo.Curso
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositoryTest {
    @Autowired
    private val repository: CursoRepository? = null

    @Autowired
    private val em: TestEntityManager? = null
    @Test
    fun deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
        val nomeCurso = "HTML 5"
        val html5 = Curso(nome = nomeCurso, categoria = toString())
        html5.nome = nomeCurso
        html5.categoria = "Programacao"
        em!!.persist(html5)
        val curso = repository!!.findByNome(nomeCurso)
        Assert.assertNotNull(curso)
        Assert.assertEquals(nomeCurso, curso!!.nome)
    }

    @Test
    fun naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
        val nomeCurso = "JPA"
        val curso = repository!!.findByNome(nomeCurso)
        Assert.assertNull(curso)
        //Assert.assertNotNull(curso)
    }
}
