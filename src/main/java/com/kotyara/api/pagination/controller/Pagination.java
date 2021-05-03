package com.kotyara.api.pagination.controller;

import com.kotyara.api.entity.Ticket;
import com.kotyara.api.pagination.dto.SearchCriteria;
import com.kotyara.api.pagination.service.PaginationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagination")
public class Pagination {

  @Autowired
  PaginationService service;

  @GetMapping
  public ResponseEntity<List<Ticket>> getAllTickets(@RequestBody SearchCriteria searchCriteria) {
    List<Ticket> list = service.findAllPagination(searchCriteria);

    return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
  }
}
