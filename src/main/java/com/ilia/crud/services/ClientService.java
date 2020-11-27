package com.ilia.crud.services;

import com.ilia.crud.model.dtos.ClientDTO;
import com.ilia.crud.model.pojo.Client;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
  public Client createClient(ClientDTO client) {
    return new Client();
  }
}
