package com.ilia.crud.controller;

import com.ilia.crud.model.dtos.UserDTO;
import com.ilia.crud.model.pojo.User;
import com.ilia.crud.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserController {
  private final UserService userService;

  @PostMapping
  public ResponseEntity<User> handleUserCreation(
      @RequestBody UserDTO userDTO
      ) {
    User user = this.userService.createUser(userDTO);
    return new ResponseEntity<>(user, HttpStatus.CREATED);
  }
}
