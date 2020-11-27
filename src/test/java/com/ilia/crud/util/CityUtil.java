package com.ilia.crud.util;

import com.ilia.crud.model.dtos.CityDTO;
import com.ilia.crud.model.enums.StateEnum;

public class CityUtil {
  public static CityDTO mountCity() {
    return CityDTO.builder()
        .name("Recife")
        .state(StateEnum.PE)
        .build();
  }
}
