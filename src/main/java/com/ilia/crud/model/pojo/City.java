package com.ilia.crud.model.pojo;

import com.ilia.crud.model.enums.StateEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
public class City extends BaseEntity {
  @Column(nullable = false, unique = true)
  private String name;
  @Column(nullable = false)
  private StateEnum state;
}
