package com.ilia.crud.util;

import com.ilia.crud.exceptions.CustomException;
import org.springframework.http.HttpStatus;

public class CustomExceptionUtil {
  public static CustomException HandleGenericCustomException(Class<?> entity, Object message, Exception exception) {
    return CustomException.builder()
        .message(message.toString())
        .details(exception.getMessage())
        .hint(entity.toGenericString())
        .status(HttpStatus.BAD_REQUEST)
        .build();
  }

  public static CustomException HandleCustomEntityNotFoundException(Class<?> entity, Object reference, Exception exception) {
    String message = String.format("%s not found - ref.: %s", entity.getName(), reference);
    return CustomException.builder()
        .message(message)
        .details(exception.getMessage())
        .hint(entity.toGenericString())
        .status(HttpStatus.NO_CONTENT)
        .build();
  }

  public static CustomException HandleCustomEntityAlreadyRegisteredException(Class<?> entity, Object reference) {
    String serializedClass = entity.getName();
    String message = String.format("%s already registered - ref.: %s", serializedClass, reference);
    return CustomException.builder()
        .message(message)
        .hint(serializedClass)
        .status(HttpStatus.ALREADY_REPORTED)
        .build();
  }
}
