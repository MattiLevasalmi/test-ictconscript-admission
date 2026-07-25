package com.levasalmi.unit_logbook;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
  
  @ExceptionHandler(BaseException.class)
  public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex, HttpServletRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setErrorCode(ex.getClass().getSimpleName());
    error.setMessage(ex.getMessage());
    error.setStatus(ex.getStatus().value());
    error.setTimestamp(Instant.now());
    error.setPath(request.getRequestURI());
    return new ResponseEntity<>(error, ex.getStatus());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {
    ErrorResponse error = new ErrorResponse();
    error.setErrorCode("ValidationError");
    error.setMessage(ex.getBindingResult().getAllErrors().stream()
        .map(errorObject -> errorObject.getDefaultMessage())
        .reduce((msg1, msg2) -> msg1 + "; " + msg2)
        .orElse("Validation failed"));
    error.setStatus(400);
    error.setTimestamp(Instant.now());
    error.setPath(request.getRequestURI());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
}
