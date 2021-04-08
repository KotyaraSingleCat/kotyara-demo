package com.kotyara.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  private String description;

  @ManyToOne
  @JoinColumn(name="user_id", nullable=false)
  private User reporter;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "priority", nullable = false)
  private String priority;

  @Column(name="time_spent")
  private String timeSpent;

  @Column(name="time_estimated", nullable = false)
  private String timeEstimated;

  @Column(name = "created_date", nullable = false)
  private LocalDateTime createdDate;

  @Column(name="type", nullable = false)
  private String type;
}
