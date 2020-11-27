package com.ilia.crud.util;

import com.ilia.crud.model.dtos.CityDTO;
import com.ilia.crud.model.dtos.ClientDTO;
import com.ilia.crud.model.enums.SexEnum;

import java.time.LocalDate;

public class ClientUtil {
  public static ClientDTO mountClientDTO() {
    CityDTO city = CityUtil.mountCity();
    return ClientDTO.builder()
        .birthDate(LocalDate.of(1997, 10, 14))
        .name("José Vinícius")
        .sex(SexEnum.M)
        .city(city)
        .build();
  }
}
