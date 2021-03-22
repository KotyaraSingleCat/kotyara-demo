package com.kotyara.api.entity;

public enum Points {
  VIEW_ALL_RECORDS("VIEW_ALL_RECORDS"),
  VIEW_OWN_RECORDS("VIEW_OWN_RECORDS"),
  CREATE_TICKET("CREATE_TICKET"),
  CLOSE_TICKET("CLOSE_TICKET");

  private String point;

  Points(String point) {
    this.point = point;
  }
}
