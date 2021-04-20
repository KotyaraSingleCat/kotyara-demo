package com.kotyara.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class TicketDTO {

  public interface New { }

  public interface Exist { }

  public interface UpdateName extends Exist { }

  public interface UpdateDescription extends Exist { }

  public interface UpdateEstimated extends Exist { }

  @Null(message = "id must be null", groups = {New.class})
  @NotNull(message = "id mustn't be null", groups = {Exist.class})
  private Integer id;

  @Null(message = "name must be null", groups = {UpdateDescription.class, UpdateEstimated.class})
  @NotNull(message = "name mustn't be null", groups = {New.class, UpdateName.class})
  private String name;

  @Null(message = "description must be null", groups = {UpdateName.class, UpdateEstimated.class})
  @NotNull(message = "description mustn't be null", groups = {New.class, UpdateDescription.class})
  private String description;

  @Null(message = "reporter_id must be null", groups = {Exist.class})
  @NotNull(message = "reporter_id mustn't be null", groups = {New.class})
  private int reporter_id;

  @Null(message = "status must be null", groups = {Exist.class})
  @NotNull(message = "status mustn't be null", groups = {New.class})
  private String status;

  @Null(message = "priority must be null", groups = {Exist.class})
  @NotNull(message = "priority mustn't be null", groups = {New.class})
  private String priority;

  @Null(message = "timeSpent must be null", groups = {Exist.class})
  @NotNull(message = "timeSpent mustn't be null", groups = {New.class})
  private String timeSpent;

  @Null(message = "estimated must be null", groups = {UpdateName.class, UpdateDescription.class})
  @NotNull(message = "estimated mustn't be null", groups = {New.class, UpdateEstimated.class})
  private String estimated;

  @Null(message = "createdDate must be null", groups = {Exist.class})
  @NotNull(message = "createdDate mustn't be null", groups = {New.class})
  private String createdDate;

  @Null(message = "type must be null", groups = {Exist.class})
  @NotNull(message = "type mustn't be null", groups = {New.class})
  private String type;

  public TicketDTO(Integer id, String name, String description, int reporter_id, String status, String priority,
      String timeSpent, String estimated, String createdDate, String type) {
    this.id = id;
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
