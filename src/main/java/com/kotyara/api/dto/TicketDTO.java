package com.kotyara.api.dto;

import lombok.Data;

@Data
public class TicketDTO {
  private String name;

  private String description;

  private int reporter_id;

  private String status;

  private String priority;

  private String timeSpent;

  private String estimated;

  private String createdDate;

  private String type;

  public TicketDTO(String name, String description, int reporter_id, String status, String priority,
      String timeSpent, String estimated, String createdDate, String type) {
    this.name = name;
    this.description = description;
    this.reporter_id = reporter_id;
    this.status = status;
    this.priority = priority;
    this.timeSpent = timeSpent;
    this.estimated = estimated;
    this.createdDate = createdDate;
    this.type = type;
  }
}
