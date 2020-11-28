package com.ilia.crud.services;

import com.ilia.crud.CrudApplicationTests;
import com.ilia.crud.exceptions.CustomException;
import com.ilia.crud.model.dtos.UserDTO;
import com.ilia.crud.model.pojo.User;
import com.ilia.crud.util.UserUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Optional;

public class UserTest extends CrudApplicationTests {
  @Test
  public void create_user() {
    UserDTO userDTO = UserUtil.mountUserDTO();
    User user = this.userService.createUser(userDTO);
    Assert.assertTrue(Objects.nonNull(user.getId()));
  }

  @Test
  public void handle_exception_when_trying_to_create_user_with_email_already_registered() {
    UserDTO userDTO = UserUtil.mountUserDTO();
    this.userService.createUser(userDTO);
    userDTO.setName("Teste");
    userDTO.setPassword("Teste");
    Throwable exception = Assert.assertThrows(CustomException.class,
        () -> this.userService.createUser(userDTO));
    String message = String.format("%s already registered - ref.: %s", User.class.getName(), userDTO.getEmail());
    Assert.assertEquals(exception.getMessage(), message);
  }

  @Test
  public void should_return_user() {
    UserDTO userDTO = UserUtil.mountUserDTO();
    User user = this.userService.createUser(userDTO);
    Optional<User> optionalUser = this.userService.findByEmail(userDTO.getEmail());
    Assert.assertEquals(user.getId(), optionalUser.orElseGet(User::new).getId());
  }

  @Test
  public void should_return_null_if_user_does_not_exist() {
    UserDTO userDTO = UserUtil.mountUserDTO();
    this.userService.createUser(userDTO);
    Optional<User> optionalUser = this.userService.findByEmail("jose@gmail.com");
    Assert.assertFalse(optionalUser.isPresent());
  }
}
