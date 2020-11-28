package com.ilia.crud.repository;

import com.ilia.crud.model.enums.StateEnum;
import com.ilia.crud.model.pojo.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ICityRepository extends JpaRepository<City, Long> {
    @Query(value = "SELECT c FROM City c WHERE upper(c.name) = upper(:name) and c.state = :state")
    Optional<City> findByNameAndState(String name, StateEnum state);

    @Query(value = "SELECT c FROM City c WHERE upper(c.name) like upper('%:name%')")
    Optional<List<City>> findAllByNameContaining(String name);

    Optional<List<City>> findAllByState(StateEnum state);

    Boolean existsByNameAndState(String name, StateEnum state);
}
