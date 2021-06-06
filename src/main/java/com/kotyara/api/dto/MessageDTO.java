package com.kotyara.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
public class MessageDTO {

  private String id;

  private String value;

  private Date date;

}
