package com.kotyara.api.pagination.dto;

import lombok.Data;

@Data
public class Condition {
  private String value;
  private String field;
  private String operation;
}
