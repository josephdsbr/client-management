package com.ilia.crud.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CustomException extends RuntimeException {
  private String message;
  private String details;
  private String hint;
  private String nextActions;
  private String support;
  private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
}
