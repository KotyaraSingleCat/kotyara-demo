package com.kotyara.api.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "action_points")
public class ActionPoints {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue
  private int id;

  @Column(name = "point", nullable = false, unique = true)
  private String point;
}
