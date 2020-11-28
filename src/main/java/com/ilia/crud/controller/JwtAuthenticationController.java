package com.ilia.crud.controller;

import com.ilia.crud.model.JwtRequest;
import com.ilia.crud.model.JwtResponse;
import com.ilia.crud.services.JwtUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
@CrossOrigin
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class JwtAuthenticationController {
  private final JwtUserDetailsService jwtAuthenticationService;

  @PostMapping
  public ResponseEntity<?> createAuthenticationToken(
      @RequestBody JwtRequest authenticationRequest
      ) {
    final String token = this.jwtAuthenticationService.handleTokenByUserDetailsEmailFilter(authenticationRequest.getUsername());
    return ResponseEntity.ok(new JwtResponse(token));
  }
}
