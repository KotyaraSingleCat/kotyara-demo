package com.kotyara.api.dto;

import lombok.Data;

@Data
public class AuthorizationDTO {
  String email;
  String password;
}
