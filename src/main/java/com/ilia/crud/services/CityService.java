package com.ilia.crud.services;

import com.ilia.crud.model.dtos.CityDTO;
import com.ilia.crud.model.enums.StateEnum;
import com.ilia.crud.model.pojo.City;
import com.ilia.crud.repository.ICityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CityService {
  private final ICityRepository repository;

  public City createCity(CityDTO cityDTO) {
    String name = cityDTO.getName();
    StateEnum state = cityDTO.getState();

    boolean cityExists = this.repository.existsByNameAndState(name, state);

    if (cityExists) {
      throw new EntityExistsException();
    }

    City city = City.builder().name(name).state(state).build();

    return this.repository.save(city);
  }

  public List<City> findByName(String name) {
    return this.repository.findAllByNameContaining(name).orElseGet(ArrayList::new);
  }

  public List<City> findByState(StateEnum state) {
    return this.repository.findAllByState(state).orElseGet(ArrayList::new);
  }

  public City findOrCreateCity(CityDTO cityDTO) {
    String name = cityDTO.getName();
    StateEnum state = cityDTO.getState();
    return this.repository
        .findByNameAndState(name, state)
        .orElseGet(() -> {
          City city = City.builder().name(name).state(state).build();
          return this.repository.save(city);
        });
  }
}
