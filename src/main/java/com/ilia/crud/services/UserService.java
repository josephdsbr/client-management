package com.ilia.crud.services;

import com.ilia.crud.exceptions.CustomException;
import com.ilia.crud.model.dtos.UserDTO;
import com.ilia.crud.model.pojo.User;
import com.ilia.crud.repository.IUserRepository;
import com.ilia.crud.util.CustomExceptionUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class UserService {
  private final IUserRepository repository;

  public User createUser(UserDTO userDTO) {
    String email = userDTO.getEmail();
    boolean userExists = this.repository.existsByEmail(email);
    if (userExists) {
      throw CustomExceptionUtil.HandleCustomEntityAlreadyRegisteredException(User.class, email);
    }

    User user = new User(userDTO.getName(), userDTO.getPassword(), email);
    return this.repository.save(user);
  }

  public Optional<User> findByEmail(String email) {
    return this.repository.findByEmailIgnoreCase(email);
  }
}
