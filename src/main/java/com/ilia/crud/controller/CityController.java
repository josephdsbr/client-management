package com.ilia.crud.controller;

import com.ilia.crud.model.dtos.CityDTO;
import com.ilia.crud.model.pojo.City;
import com.ilia.crud.services.CityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/city")
@Slf4j
@CrossOrigin(origins = "*")
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class CityController {
  private final CityService cityService;

  @PostMapping
  public ResponseEntity<City> handleUserCreation(
      @RequestBody CityDTO cityDTO
      ) {
    try {
      City city = this.cityService.createCity(cityDTO);
      return new ResponseEntity<>(city, HttpStatus.CREATED);
    } catch (Exception exception) {
      return new ResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
