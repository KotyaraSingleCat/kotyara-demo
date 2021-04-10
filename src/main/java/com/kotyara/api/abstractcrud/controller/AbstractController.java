package com.kotyara.api.abstractcrud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AbstractController <Entity, DTO> {

  @GetMapping("/{id}")
  ResponseEntity<Entity> getById(@PathVariable int id);

  @GetMapping
  List<Entity> getAll();

  @PostMapping
  void create(@RequestBody DTO dto);

  @DeleteMapping("/{id}")
  void delete(@PathVariable int id);
}
