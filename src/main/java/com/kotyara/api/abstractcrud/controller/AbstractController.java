package com.kotyara.api.abstractcrud.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AbstractController <Entity, DTO> {

  @GetMapping("/{id}")
  ResponseEntity<Entity> getById(@PathVariable int id);

  @GetMapping
  List<Entity> getAll();

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  void create(@RequestBody DTO dto);

  @DeleteMapping("/{id}")
  void delete(@PathVariable int id);
}
