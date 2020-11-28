package com.ilia.crud.controller;

import com.ilia.crud.model.dtos.ClientDTO;
import com.ilia.crud.model.dtos.ClientHandleNameDTO;
import com.ilia.crud.model.pojo.Client;
import com.ilia.crud.services.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@Slf4j
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ClientController {
  private final ClientService clientService;

  @PostMapping
  public ResponseEntity<Client> handleUserCreation(
      @RequestBody ClientDTO clientDTO
      ) {
      Client client = this.clientService.createClient(clientDTO);
      return new ResponseEntity<>(client, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Client>> handleFindingUserByName(
      @RequestParam(name = "name") String name
  ) {
    List<Client> clients = this.clientService.findByName(name);
    return new ResponseEntity<>(clients, HttpStatus.OK);
  }

  @PutMapping
  public ResponseEntity<Client> handleUserNameUpdate(
      @RequestBody ClientHandleNameDTO clientHandleNameDTO
      ) {
    Client client = this.clientService.updateNameById(clientHandleNameDTO);
    return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("{id}")
  public ResponseEntity<Client> handleUserRemove(
      @PathVariable(name = "id") Long id
  ) {
    Client client = this.clientService.removeByID(id);
    return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
  }
}
