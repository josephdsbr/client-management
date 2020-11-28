package com.ilia.crud.services;

import com.ilia.crud.CrudApplicationTests;
import com.ilia.crud.exceptions.CustomException;
import com.ilia.crud.model.dtos.ClientDTO;
import com.ilia.crud.model.dtos.ClientHandleNameDTO;
import com.ilia.crud.model.pojo.Client;
import com.ilia.crud.util.ClientUtil;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ClientTest extends CrudApplicationTests {

  @Test
  public void create_user() {
    ClientDTO clientDTO = ClientUtil.mountClientDTO();
    Client client = this.clientService.createClient(clientDTO);
    Assert.assertTrue(Objects.nonNull(client.getName()));
  }

  @Test
  public void handle_exception_when_search_for_client_not_registered() {
    Long id = 10000L;
    Throwable exception = Assert.assertThrows(CustomException.class,
        () -> this.clientService.findById(id));
    Assert.assertEquals(exception.getMessage(), String.format("Entity not found - ref.: %s", id));
  }

  @Test
  public void do_not_forbid_create_user_with_same_information() {
    ClientDTO clientDTO = ClientUtil.mountClientDTO();
    Client preExistedClient = this.clientService.createClient(clientDTO);
    Client newClient = this.clientService.createClient(clientDTO);
    Assert.assertNotEquals(newClient.getId(), preExistedClient.getId());
  }

  @Test
  public void handle_logical_delete_on_user() {
    ClientDTO clientDTO = ClientUtil.mountClientDTO();
    Client client = this.clientService.createClient(clientDTO);
    Client excludedClient = this.clientService.removeByID(client.getId());
    Assert.assertNotNull(excludedClient.getRemovedAt());
  }

  @Test
  public void handle_exception_when_trying_to_remove_client_does_not_exist() {
    Long id = 10000L;
    Throwable exception = Assert.assertThrows(CustomException.class,
        () -> this.clientService.removeByID(id));
    Assert.assertEquals(exception.getMessage(), String.format("Entity not found - ref.: %s", id));
  }

  @Test
  public void handle_find_user_by_id() {
    ClientDTO clientDTO = ClientUtil.mountClientDTO();
    Client client = this.clientService.createClient(clientDTO);
    Client userFound = this.clientService.findById(client.getId());
    Assert.assertEquals(userFound.getId(), client.getId());
  }

  @Test
  public void handle_exception_when_trying_to_updae_client_does_not_exist() {
    Long id = 10000L;
    String name = "Bruno";
    ClientHandleNameDTO clientHandleNameDTO = ClientUtil.mountClientHandleNameDTO(id, name);
    Throwable exception = Assert.assertThrows(CustomException.class,
        () -> this.clientService.updateNameById(clientHandleNameDTO));
    Assert.assertEquals(exception.getMessage(), String.format("Entity not found - ref.: %s", id));
  }


  @Test
  public void handle_find_user_by_name() {
    ClientDTO clientDTO = ClientUtil.mountClientDTO();
    this.clientService.createClient(clientDTO);
    List<Client> usersFound = this.clientService.findByName(clientDTO.getName().toLowerCase());
    Assert.assertEquals(1, usersFound.size());
  }

  @Test
  public void handle_update_client_name() {
    String name = "Bruno";
    ClientDTO clientDTO = ClientUtil.mountClientDTO();
    Client client = this.clientService.createClient(clientDTO);
    ClientHandleNameDTO clientHandleNameDTO = ClientUtil.mountClientHandleNameDTO(client.getId(), name);
    Client updatedClient = this.clientService.updateNameById(clientHandleNameDTO);
    Assert.assertEquals(updatedClient.getName(), name);
  }
}
