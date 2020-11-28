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

  public static CustomException HandleCustomEntityNotFoundException(Class entity, Object reference, Exception exception) {
    String message = String.format("Entity not found - ref.: %s", reference);
    return CustomException.builder()
        .message(message)
        .details(exception.getMessage())
        .hint(entity.toGenericString())
        .build();
  }
}
