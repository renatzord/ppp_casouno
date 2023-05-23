package com.api.ppp.back.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(ConstraintViolationException ex) {
        Map<String, String> fieldErrors = new HashMap<>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            String field = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            fieldErrors.put(field, message);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(fieldErrors);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorMessage> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ErrorMessage errorResponse = new ErrorMessage(HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(), "Error de integridad de datos (registro existente).",
                ex.getRootCause().getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage errorResponse = new ErrorMessage();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setDate(LocalDateTime.now());
        errorResponse.setMessage("Recurso no encontrado");
        errorResponse.setDescription(ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    public ResponseEntity<ErrorMessage> handleJpaObjectRetrievalFailureException(JpaObjectRetrievalFailureException ex) {
        ErrorMessage errorResponse = new ErrorMessage();
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorResponse.setDate(LocalDateTime.now());
        errorResponse.setMessage("EL recurso no se encuentra en la base de datos.");
        errorResponse.setDescription(ex.getRootCause().getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

}
