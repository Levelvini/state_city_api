package com.levelvini.test_dev.exceptions.treatment;

import com.levelvini.test_dev.exceptions.EmptyDataException;
import com.levelvini.test_dev.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> Exception(Exception ex) {
        ErroResponse erro = new ErroResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.toString());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(erro);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErroResponse> handlerHttpMessageNorReadableException(HttpMessageNotReadableException ex) {
        ErroResponse erro = new ErroResponse(LocalDateTime.now(), "Error", HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroResponse> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        ErroResponse erro = new ErroResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(EmptyDataException.class)
    public ResponseEntity<ErroResponse> handlerEmptyDataException(EmptyDataException ex) {
        ErroResponse erro = new ErroResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErroResponse> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ErroResponse erro = new ErroResponse(LocalDateTime.now(), "Verifique o endereço de request", HttpStatus.NOT_FOUND.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
