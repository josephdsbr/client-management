package com.ilia.crud.model.pojo;

import com.ilia.crud.model.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder
@Entity
public class Client extends BaseEntity {
  /**
   * The user's contact details
   */
  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private SexEnum sex;

  @Column(nullable = false)
  private LocalDate birthDate;

  @Column(nullable = false)
  @Formula(value = "date_part(‘year’, age(birthDate))")
  private int age;

  @OneToOne
  @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
  private City city;
}
