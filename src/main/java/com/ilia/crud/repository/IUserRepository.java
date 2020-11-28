package com.ilia.crud.repository;

import com.ilia.crud.model.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
  boolean existsByEmail(String email);
  Optional<User> findByEmailIgnoreCase(String email);
}
