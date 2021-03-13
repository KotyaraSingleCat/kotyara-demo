package com.kotyara.api.dto;

import lombok.*;

@Data
public class UserDTO {

  private String firstName;

  private String secondName;

  private String email;

  private String password;

  public UserDTO(String firstName, String secondName, String email, String password) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
    this.password = password;
  }
}
