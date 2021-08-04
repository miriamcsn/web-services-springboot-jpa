package com.myfactory.webservicesjpa.resource.exceptions;

import com.myfactory.webservicesjpa.services.exceptions.DatabaseException;
import com.myfactory.webservicesjpa.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice  // intercepta as exceçoes para fazer o tratamento adequado
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    // essa anotacao diz que esse metodo vai captar toda excecao do tipo resource(...)
    // e vai tratar como especificado abaixo
    public ResponseEntity<StandardError> resourceNotFound
            (ResourceNotFoundException e,
             HttpServletRequest request) {

        String error = "Resource not found.";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(
                Instant.now(),
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException
            (DatabaseException e,
             HttpServletRequest request) {

        String error = "Database error.";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError(
                Instant.now(),
                status.value(),
                error,
                e.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(standardError);
    }

}
