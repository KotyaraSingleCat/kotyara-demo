package com.kotyara.api.entity;

import lombok.*;

@Data
public class User {

  private int id;

  private String firstName;

  private String secondName;

  private String email;

  private String password;

  public User(int id, String firstName, String secondName, String email, String password) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
    this.password = password;
  }
}
