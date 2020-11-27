package com.ilia.crud.model.dtos;

import com.ilia.crud.model.enums.StateEnum;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class CityDTO {
  @NotNull
  private String name;
  @NotNull
  private StateEnum state;
}
