package com.antonio.apirest.config.validacao

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.http.HttpStatus
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.util.function.Consumer


@RestControllerAdvice
class ErroDeValidacaoHandler {

    @Autowired
    private val messageSource: MessageSource? = null

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handle(exception: MethodArgumentNotValidException): List<ErroDeFormularioDto> {
        val dto: MutableList<ErroDeFormularioDto> = ArrayList()
        val fieldErrors = exception.bindingResult.fieldErrors
        fieldErrors.forEach(Consumer { e: FieldError ->
            val mensagem = messageSource!!.getMessage(e, LocaleContextHolder.getLocale())
            val erro = ErroDeFormularioDto(e.field, mensagem)
            dto.add(erro)
        })
        return dto
    }
}