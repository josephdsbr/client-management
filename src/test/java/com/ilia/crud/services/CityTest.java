package com.ilia.crud.services;

import com.ilia.crud.CrudApplicationTests;
import com.ilia.crud.exceptions.CustomException;
import com.ilia.crud.model.dtos.CityDTO;
import com.ilia.crud.model.enums.StateEnum;
import com.ilia.crud.model.pojo.City;
import com.ilia.crud.util.CityUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

public class CityTest extends CrudApplicationTests {
  @Test
  public void create_city() {
    CityDTO cityDTO = CityUtil.mountCity();
    City city = this.cityService.createCity(cityDTO);
    Assert.assertTrue(Objects.nonNull(city.getId()));
  }

  @Test
  public void handle_exception_create_city_already_registered() {
    CityDTO cityDTO = CityUtil.mountCity();
    City city = this.cityService.createCity(cityDTO);

    Throwable exception = Assert.assertThrows(CustomException.class,
        () -> this.cityService.createCity(cityDTO));
    Assert.assertTrue(Objects.nonNull(exception.getMessage()));
  }

  @Test
  public void handle_should_return_city_already_registered() {
    CityDTO cityDTO = CityUtil.mountCity();
    City city = this.cityService.createCity(cityDTO);
    City registeredCity = this.cityService.findOrCreateCity(cityDTO);
    Assert.assertEquals(city.getId(), registeredCity.getId());
  }

  @Test
  public void handle_should_create_city_if_not_registered() {
    CityDTO cityDTO = CityUtil.mountCity();
    City registeredCity = this.cityService.findOrCreateCity(cityDTO);
    Assert.assertTrue(Objects.nonNull(registeredCity.getId()));
  }

  @Test
  public void handle_exception_when_name_and_state_are_null() {
    Throwable exception = Assert.assertThrows(CustomException.class,
        () -> this.cityService.findByNameOrState(null, null));
    Assert.assertEquals(exception.getMessage(), "Name or state must not be null");
  }

  @Test
  public void handle_find_by_name() {
    String name = "Recife";
    CityDTO cityDTO = CityUtil.mountCity();
    cityDTO.setName(name);
    this.cityService.createCity(cityDTO);
    List<City> filteredCity = this.cityService.findByNameOrState(name, null);
    Assert.assertTrue(filteredCity.stream().allMatch(city -> city.getName().toUpperCase().equals(name.toUpperCase())));
  }

  @Test
  public void handle_find_by_state() {
    StateEnum state = StateEnum.AC;
    CityDTO cityDTO = CityUtil.mountCity();
    cityDTO.setState(state);
    this.cityService.createCity(cityDTO);
    List<City> filteredCity = this.cityService.findByNameOrState(null, state);
    Assert.assertTrue(filteredCity.stream().allMatch(city -> city.getState().equals(StateEnum.AC)));
  }
}
