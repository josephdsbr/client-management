package com.ilia.crud.repository;

import com.ilia.crud.model.pojo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Long> {
  @Query("SELECT c FROM Client c WHERE c.name like upper('%:name%')")
  Optional<List<Client>> findAllByNameContaining(String name);
}
