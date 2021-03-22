package com.kotyara.api.entity;

public enum Roles {
  ADMIN("ADMIN"),
  DEVELOPER("DEVELOPER"),
  ANALYST("ANALYST");

  private String role;

  Roles(String role) {
    this.role = role;
  }
}
