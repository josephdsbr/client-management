package com.ilia.crud.exceptions;

import lombok.*;

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
}
