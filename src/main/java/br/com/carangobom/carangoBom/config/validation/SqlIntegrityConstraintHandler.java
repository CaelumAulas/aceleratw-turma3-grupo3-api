package br.com.carangobom.carangoBom.config.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;

@ResponseStatus(code = HttpStatus.CONFLICT)
@RestControllerAdvice
public class SqlIntegrityConstraintHandler
{
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)

    public ResponseEntity<?> handle(SQLIntegrityConstraintViolationException exception)
    {

        return ResponseEntity.status(HttpStatus.CONFLICT).body("It is not possible to perform this action. The entity in question has relationships.");
    }


}
