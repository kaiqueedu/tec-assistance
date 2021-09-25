package br.edu.dw2.tecassistance.exceptionhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class TecAssistanceExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    protected ResponseEntity<Object> handlerHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                   HttpHeaders headers,
                                                                   HttpStatus status,
                                                                   WebRequest request){
        String mensagemUsuario = messageSource.getMessage("invalid.message", null, LocaleContextHolder.getLocale());
        String msgDev = ex.getCause().toString();
        return super.handleExceptionInternal(ex,
                new Erro(mensagemUsuario, msgDev),
                headers,
                HttpStatus.BAD_REQUEST,
                request);
    }

    public static class Erro{
        private String msgUser;
        private String msgDev;

        public Erro(String msgUser, String msgDev) {
            this.msgUser = msgUser;
            this.msgDev = msgDev;
        }

        public String getMsgUser(){return msgUser;}
    }
}
