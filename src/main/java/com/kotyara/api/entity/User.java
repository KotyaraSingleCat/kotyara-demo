package com.kotyara.api.entity;

import lombok.*;

@Data
public class User {

  private int id;

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private UserRole role;

  public User(int id, String firstName, String lastName, String email, String password, UserRole role) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}
