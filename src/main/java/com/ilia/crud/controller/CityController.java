package com.ilia.crud.controller;

import com.ilia.crud.model.dtos.CityDTO;
import com.ilia.crud.model.enums.StateEnum;
import com.ilia.crud.model.pojo.City;
import com.ilia.crud.services.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
@Slf4j
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CityController {
  private final CityService cityService;

  @PostMapping
  public ResponseEntity<City> handleCityCreation(
      @RequestBody CityDTO cityDTO
  ) {
    City city = this.cityService.createCity(cityDTO);
    return new ResponseEntity<>(city, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<City>> handleCityFindByNameOrState(
      @RequestParam(required = false, name = "name") String name,
      @RequestParam(required = false, name = "state") StateEnum state
  ) {
    List<City> cities = this.cityService.findByNameOrState(name, state);
    return new ResponseEntity<>(cities, HttpStatus.OK);
  }

}
