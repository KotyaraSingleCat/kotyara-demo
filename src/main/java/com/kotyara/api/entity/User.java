package com.kotyara.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NamedEntityGraph(
    name = "graph.UserRoleActionPoint",
    attributeNodes = @NamedAttributeNode(value = "role", subgraph = "subgraph.role"),
    subgraphs = {
        @NamedSubgraph(name="subgraph.role", attributeNodes = @NamedAttributeNode(value = "actionPoints"))
    }
)
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User {

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "firstName", nullable = false)
  private String firstName;

  @Column(name = "lastName", nullable = false)
  private String lastName;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JsonManagedReference
  private UserRole role;
}
