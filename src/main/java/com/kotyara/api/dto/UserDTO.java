package com.kotyara.api.dto;

import lombok.*;

@Getter
@Setter
public class UserDTO {

  private String firstName;

  private String secondName;

  private String email;

  public UserDTO(String firstName, String secondName, String email) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
  }
}
