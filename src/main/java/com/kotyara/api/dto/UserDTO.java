package com.kotyara.api.dto;


import com.kotyara.api.validator.Password;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class UserDTO {

  public interface New { }

  public interface Exist { }

  public interface UpdatePassword extends Exist { }

  public interface UpdateEmail extends Exist { }

  @Null(message = "id must be null", groups = {New.class})
  @NotNull(message = "id mustn't be null", groups = {Exist.class})
  private Integer id;

  @Null(message = "firstName must be null", groups = {Exist.class})
  @NotNull(message = "firstName mustn't be null", groups = {New.class})
  private String firstName;

  @Null(message = "lastName must be null", groups = {Exist.class})
  @NotNull(message = "lastName mustn't be null", groups = {New.class})
  private String lastName;

  @Null(message = "email must be null", groups = {UpdatePassword.class})
  @NotNull(message = "email mustn't be null", groups = {New.class, UpdateEmail.class})
  private String email;

  @Password(groups = {New.class, UpdatePassword.class})
  @Null(message = "password must be null", groups = {UpdateEmail.class})
  @NotNull(message = "password mustn't be null", groups = {New.class, UpdatePassword.class})
  private String password;

  @Null(message = "role_id must be null", groups = {Exist.class})
  @NotNull(message = "role_id mustn't be null", groups = {New.class})
  private int role_id;

  public UserDTO(Integer id, String firstName, String lastName, String email, String password, int role_id) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.role_id = role_id;
  }
}
