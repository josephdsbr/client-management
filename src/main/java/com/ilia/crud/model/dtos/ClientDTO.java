package com.ilia.crud.model.dtos;

import com.ilia.crud.model.enums.SexEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDTO {
  @NotNull
  private String name;

  @NotNull
  private SexEnum sex;

  @NotNull
  private LocalDate birthDate;

  @NotNull
  private CityDTO city;
}
