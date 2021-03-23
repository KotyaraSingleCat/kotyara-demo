package com.kotyara.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "action_points")
public class ActionPoints {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue
  private int id;

  @Column(name = "point", nullable = false, unique = true)
  @Enumerated(EnumType.STRING)
  private Points point;

  @ManyToMany(cascade = { CascadeType.ALL }, mappedBy = "actionPoints")
  private List<UserRole> roles;
}
