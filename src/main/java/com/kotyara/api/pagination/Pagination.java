package com.kotyara.api.pagination;

import com.kotyara.api.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagination")
public class Pagination {

  @Autowired
  PaginationService service;

  @GetMapping
  public ResponseEntity<List<Ticket>> getAllEmployees(
      @RequestParam Integer pageNo,
      @RequestParam Integer pageSize,
      @RequestParam String sortBy) {
    List<Ticket> list = service.getAllEmployees(pageNo, pageSize, sortBy);

    return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
  }
}
