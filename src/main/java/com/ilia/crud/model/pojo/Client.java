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
import java.time.temporal.ChronoUnit;

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
  private long age;

  @OneToOne
  @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
  private City city;

  @PrePersist
  @PreUpdate
  protected void handleAge() {
    LocalDate today = LocalDate.now();
    this.age = this.birthDate.until(today, ChronoUnit.YEARS);
  }
}
