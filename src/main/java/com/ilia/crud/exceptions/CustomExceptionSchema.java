package com.ilia.crud.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomExceptionSchema {
  private String message;
  private String details;
  private String hint;
  private String nextActions;
  private String support;
}
