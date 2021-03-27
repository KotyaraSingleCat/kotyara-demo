package com.kotyara.api.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(of = "id")
@Table(name = "roles")
public class UserRole {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private int id;

  @Column(name = "role", nullable = false)
  private String role;

  @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
  @JoinTable(
      name = "action_points_roles",
      joinColumns = {@JoinColumn(name = "role_id")},
      inverseJoinColumns = {@JoinColumn(name = "action_point_id")}
  )
  private List<ActionPoints> actionPoints;
}
