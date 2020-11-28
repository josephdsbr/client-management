package com.ilia.crud.services;

import com.ilia.crud.model.pojo.User;
import com.ilia.crud.util.CustomExceptionUtil;
import com.ilia.crud.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class JwtUserDetailsService implements UserDetailsService {
  private final UserService userService;
  private final JwtTokenUtil jwtTokenUtil;
  @Override
  public User loadUserByUsername(String email) throws UsernameNotFoundException {
    try {
      return this.userService.findByEmail(email).orElseThrow(EntityNotFoundException::new);
    } catch (EntityNotFoundException exception) {
      throw CustomExceptionUtil.HandleCustomEntityNotFoundException(User.class, email, exception);
    }
  }

  public String handleTokenByUserDetailsEmailFilter(String email) {
    User user  = loadUserByUsername(email);
    return jwtTokenUtil.generateToken(user);
  }
}
