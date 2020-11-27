package com.ilia.crud.repository;

import com.ilia.crud.model.pojo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
