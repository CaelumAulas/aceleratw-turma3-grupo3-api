package br.com.carangobom.carangoBom.config.validation;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@ResponseStatus(code = HttpStatus.NOT_FOUND)
@RestControllerAdvice
public class EmptyResultHandler
{

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<?> handle(EmptyResultDataAccessException exception)
    {
        return ResponseEntity.notFound().build();
    }

}