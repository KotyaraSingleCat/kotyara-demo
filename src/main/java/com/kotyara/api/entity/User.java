package com.kotyara.api.entity;

import lombok.*;
import java.util.List;
import javax.persistence.*;

@NamedEntityGraph(
    name = "graph.UserRole",
    attributeNodes = @NamedAttributeNode(value = "role")
)
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

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  private UserRole role;

  @OneToMany(mappedBy="reporter")
  private List<Ticket> tickets;
}
