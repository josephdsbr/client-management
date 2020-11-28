package com.ilia.crud.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

public class BCryptUtil {
  private static final int salt = 10;
  private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(salt, new SecureRandom());

  public static String encode(String value) {
    return encoder.encode(value);
  }
}
