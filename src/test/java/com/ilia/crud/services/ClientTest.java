package com.ilia.crud.services;

import com.ilia.crud.CrudApplicationTests;
import com.ilia.crud.model.dtos.ClientDTO;
import com.ilia.crud.model.pojo.Client;
import com.ilia.crud.util.ClientUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class ClientTest extends CrudApplicationTests {

  @Test
  public void create_user() {
    ClientDTO clientDTO = ClientUtil.mountClientDTO();
    Client client = this.clientService.createClient(clientDTO);
    Assert.assertTrue(Objects.nonNull(client.getName()));
  }

  @Test
  public void contextLoads() {
    Assert.assertTrue(true);
  }
}
