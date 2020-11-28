package com.ilia.crud.repository;

import com.ilia.crud.model.pojo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IClientRepository extends JpaRepository<Client, Long> {
  Optional<List<Client>> findAllByNameIgnoreCase(String name);
}
