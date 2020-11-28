package com.ilia.crud.services;

import com.ilia.crud.exceptions.CustomException;
import com.ilia.crud.model.dtos.CityDTO;
import com.ilia.crud.model.enums.StateEnum;
import com.ilia.crud.model.pojo.City;
import com.ilia.crud.repository.ICityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CityService {
  private final ICityRepository repository;

  public City createCity(CityDTO cityDTO) {
    String name = cityDTO.getName();
    StateEnum state = cityDTO.getState();

    boolean cityExists = this.repository.existsByNameIgnoreCaseAndState(name, state);

    if (cityExists) {
      throw CustomException.builder()
          .message("City already registered")
          .details("The City you tried to register is already registered in the database")
          .build();
    }

    City city = City.builder().name(name).state(state).build();

    return this.repository.save(city);
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

  public List<City> findByNameOrState(String name, StateEnum state) {
    if (Objects.isNull(name) && Objects.isNull(state)) {
      throw CustomException.builder()
          .message("Name or state must not be null")
          .details("You have send a request to search for name or state without specifing any of these paramteres")
          .nextActions("Remake the request specifying at least one of the parameters.")
          .build();
    }
    return this.repository.findAllByNameIgnoreCaseOrState(name, state);
  }
}
