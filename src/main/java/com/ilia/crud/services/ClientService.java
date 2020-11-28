package com.ilia.crud.services;

import com.ilia.crud.model.dtos.ClientDTO;
import com.ilia.crud.model.dtos.ClientHandleNameDTO;
import com.ilia.crud.model.pojo.City;
import com.ilia.crud.model.pojo.Client;
import com.ilia.crud.repository.IClientRepository;
import com.ilia.crud.util.CustomExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class ClientService {
  private final IClientRepository clientRepository;
  private final CityService cityService;

  public Client createClient(ClientDTO clientDTO) {
    City city = this.cityService.findOrCreateCity(clientDTO.getCity());
    Client client = Client
        .builder()
        .birthDate(clientDTO.getBirthDate())
        .name(clientDTO.getName())
        .sex(clientDTO.getSex())
        .city(city)
        .build();
    return this.clientRepository.save(client);
  }

  public List<Client> findByName(String name) {
    try {
      return this.clientRepository.findAllByNameIgnoreCase(name).orElseGet(ArrayList::new);
    } catch (Exception exception) {
      String message = "An error occurred in consulting database.";
      throw CustomExceptionUtil.HandleGenericCustomException(Client.class, message, exception);
    }
  }

  public Client findById(Long id) {
    try {
      return this.clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    } catch (Exception exception) {
      throw CustomExceptionUtil.HandleCustomEntityNotFoundException(Client.class, id, exception);
    }
  }

  public Client removeByID(Long id) {
    try {
      Client client = this.clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
      LocalDateTime today = LocalDateTime.now();
      client.setRemovedAt(today);
      return this.clientRepository.save(client);
    }
    catch (EntityNotFoundException exception) {
      throw CustomExceptionUtil.HandleCustomEntityNotFoundException(Client.class, id, exception);
    }
  }

  public Client updateNameById(ClientHandleNameDTO clientHandleNameDTO) {
    Long id = clientHandleNameDTO.getId();
    String name = clientHandleNameDTO.getName();
    try {
      Client client = this.clientRepository.findById(id).orElseThrow(EntityNotFoundException::new);
      client.setName(name);
      return client;
    } catch (EntityNotFoundException exception) {
      throw CustomExceptionUtil.HandleCustomEntityNotFoundException(Client.class, id, exception);
    }
  }
}
