package com.ilia.crud.controller;

import com.ilia.crud.model.pojo.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@Slf4j
@CrossOrigin(origins = "*")
public class ClientController {
  @PostMapping
  public ResponseEntity<Client> handleUserCreation() {
    return new ResponseEntity<>(new Client(), HttpStatus.OK);
  }
}
