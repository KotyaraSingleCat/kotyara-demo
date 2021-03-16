package com.kotyara.api.dto;

import lombok.*;

@Data
public class UserDTO {

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private String role;

  public UserDTO(String firstName, String lastName, String email, String password, String role) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}
