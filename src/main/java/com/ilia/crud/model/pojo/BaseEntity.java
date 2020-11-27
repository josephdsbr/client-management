package com.ilia.crud.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@MappedSuperclass
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private UUID uid;

  @Column
  @CreationTimestamp
  protected LocalDateTime createdAt;

  @Column
  @UpdateTimestamp
  protected LocalDateTime lastUpdatedAt;

  @Column
  protected LocalDateTime removedAt;

  @PrePersist
  private void setUid() {
    this.uid = UUID.randomUUID();
  }
}
