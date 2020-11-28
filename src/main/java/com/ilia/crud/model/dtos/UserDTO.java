package com.ilia.crud.model.dtos;

import com.ilia.crud.model.enums.SexEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
  @NotNull
  private String name;

  @NotNull
  @Email
  private String email;

  @NotNull
  private String password;
}
