package com.antonio.apirest.config.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@EnableWebSecurity
@Configuration
class SecurityConfigurations : WebSecurityConfigurerAdapter() {
    @Autowired
    private val autenticacaoService: AutenticacaoService? = null

    //Configuracoes de autenticacao
    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService<UserDetailsService?>(autenticacaoService).passwordEncoder(BCryptPasswordEncoder())
    }

    //Configuracoes de autorizacao
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET, "/topicos").permitAll()
            .antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
    }

    //Configuracoes de recursos estaticos(js, css, imagens, etc.)
    @Throws(Exception::class)
    override fun configure(web: WebSecurity) {
    }
}