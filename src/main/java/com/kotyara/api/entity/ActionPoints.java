package com.kotyara.api.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "action_points")
@Immutable
public class ActionPoints {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private int id;

  @Column(name = "point", nullable = false, unique = true)
  private String point;
}
