package com.ilia.crud.model.pojo;

import com.ilia.crud.util.BCryptUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.util.Collection;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
@Table(name = "oauth")
public class User extends BaseEntity implements UserDetails {
  @Column(nullable = false)
  private String username;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String password;

  @Column(nullable = false)
  private Boolean isAccountNonExpired = Boolean.TRUE;

  @Column(nullable = false)
  private Boolean isAccountNonLocked = Boolean.TRUE;

  @Column(nullable = false)
  private Boolean isCredentialsNonExpired = Boolean.TRUE;

  @Column(nullable = false)
  private Boolean isEnabled = Boolean.TRUE;

  public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public boolean isAccountNonExpired() {
    return isAccountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return isAccountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return isCredentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return isEnabled;
  }

  @PrePersist
  protected void handlePasswordEncoder() {
    this.password = BCryptUtil.encode(this.password);
  }
}
