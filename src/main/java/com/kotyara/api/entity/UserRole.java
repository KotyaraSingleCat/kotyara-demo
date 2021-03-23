package com.kotyara.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "roles")
public class UserRole {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  private Roles role;

  @OneToOne(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
  private User user;

  @ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
  @JoinTable(
      name = "action_points_roles",
      joinColumns = { @JoinColumn(name = "role_id") },
      inverseJoinColumns = { @JoinColumn(name = "action_point_id") }
  )
  private List<ActionPoints> actionPoints;
}
