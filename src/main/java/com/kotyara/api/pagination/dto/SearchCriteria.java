package com.kotyara.api.pagination.dto;

import lombok.Data;

@Data
public class SearchCriteria {
  private long offset;
  private int limit;
  private Condition condition;
}
