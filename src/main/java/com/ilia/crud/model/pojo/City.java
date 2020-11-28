package com.ilia.crud.model.pojo;

import com.ilia.crud.model.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
public class City extends BaseEntity {
  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  private StateEnum state;

  @PrePersist
  @PreUpdate
  private void handleName() {
    this.name = this.name.toUpperCase();
  }
}
