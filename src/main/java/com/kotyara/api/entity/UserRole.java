package com.kotyara.api.entity;

import lombok.Data;

public enum UserRole {
  ADMIN("ADMIN"),
  DEVELOPER("DEVELOPER"),
  ANALYST("ANALYST");

  private String role;

  UserRole(String role) {
    this.role = role;
  }
}
