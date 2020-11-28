package com.ilia.crud.model.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientHandleNameDTO {
  @NotNull
  Long id;

  @NotNull
  String name;
}
