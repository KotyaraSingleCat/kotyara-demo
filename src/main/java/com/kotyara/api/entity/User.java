package com.kotyara.api.entity;

import lombok.*;

@Getter
@Setter
public class User {

  private int id;

  private String firstName;

  private String secondName;

  private String email;

  public User(int id, String firstName, String secondName, String email) {
    this.id = id;
    this.firstName = firstName;
    this.secondName = secondName;
    this.email = email;
  }
}
