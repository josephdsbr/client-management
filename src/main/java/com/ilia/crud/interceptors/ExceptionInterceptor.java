package com.ilia.crud.interceptors;

import com.ilia.crud.exceptions.CustomException;
import com.ilia.crud.exceptions.CustomExceptionSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
  @ExceptionHandler(CustomException.class)
  public final ResponseEntity<Object> handleAllExceptions(CustomException exception) {
    CustomExceptionSchema exceptionResponse = CustomExceptionSchema
        .builder()
        .message(exception.getMessage())
        .details(exception.getDetails())
        .hint(exception.getHint())
        .nextActions(exception.getNextActions())
        .support(exception.getSupport())
        .build();
    return new ResponseEntity<>(exceptionResponse, exception.getStatus());
  }
}
