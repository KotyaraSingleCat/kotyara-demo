package com.kotyara.api.abstractcrud.controller;

import com.kotyara.api.abstractcrud.service.AbstractService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class AbstractControllerImpl<Entity, DTO> implements AbstractController<Entity, DTO> {

  private final AbstractService<Entity, DTO> service;

  public AbstractControllerImpl(AbstractService<Entity, DTO> service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<Entity> getById(@PathVariable int id) {
    Entity entity = service.getById(id);
    if (entity == null) {
      return ResponseEntity.notFound().build();
    } else {
      return ResponseEntity.ok(entity);
    }
  }

  @Override
  public List<Entity> getAll() {
    return service.getAll();
  }

  @Override
  public void create(@RequestBody DTO dto) {
    service.create(dto);
  }

  @Override
  public void delete(@PathVariable int id) {
    service.remove(id);
  }
}
