package com.ilia.crud.util;

import com.ilia.crud.exceptions.CustomException;

import java.util.Objects;

public class CustomExceptionUtil {
  public static CustomException HandleGenericCustomException(Class<?> entity, Object message, Exception exception) {
    return CustomException.builder()
        .message(message.toString())
        .details(exception.getMessage())
        .hint(entity.toGenericString())
        .build();
  }

  public static CustomException HandleCustomEntityNotFoundException(Class<?> entity, Object reference, Exception exception) {
    String message = String.format("%s not found - ref.: %s", entity.getName(), reference);
    return CustomException.builder()
        .message(message)
        .details(exception.getMessage())
        .hint(entity.toGenericString())
        .build();
  }

  public static CustomException HandleCustomEntityAlreadyRegisteredException(Class<?> entity, Object reference) {
    String serializedClass = entity.toGenericString();
    String message = String.format("%s already registered - ref.: %s", serializedClass, reference);
    return CustomException.builder()
        .message(message)
        .hint(serializedClass)
        .build();
  }
}
