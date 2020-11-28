package com.ilia.crud.util;

import com.ilia.crud.model.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {
  private static final long serialVersionUID = -2550185165626007488L;

  @Value("${jwt.secret}")
  private String secret;

  @Value("${jwt.expiration}")
  private int jwtTokenValidity;

  public String getUsernameFromToken(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }


  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
  }

  private boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  public String generateToken(User user) {
    Map<String, Object> claims = new HashMap<>();
    return doGenerateToken(claims, user.getEmail());
  }

  private String doGenerateToken(Map<String, Object> claims, String subject) {
    Date issuedAt = new Date(System.currentTimeMillis());
    Date expirationAt = new Date(System.currentTimeMillis() + jwtTokenValidity * 1000);
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(issuedAt)
        .setExpiration(expirationAt)
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  public Boolean validateToken(String token, User user) {
    final String username = getUsernameFromToken(token);
    return (username.equals(user.getEmail()) && !isTokenExpired(token));
  }

}
