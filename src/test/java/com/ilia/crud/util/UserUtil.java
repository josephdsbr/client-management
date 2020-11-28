package com.ilia.crud.util;

import com.ilia.crud.model.dtos.UserDTO;

public class UserUtil {
  public static UserDTO mountUserDTO() {
    return UserDTO.builder()
        .email("josephdsbr@gmail.com")
        .name("José Vinícius")
        .password("123456")
        .build();
  }
}
