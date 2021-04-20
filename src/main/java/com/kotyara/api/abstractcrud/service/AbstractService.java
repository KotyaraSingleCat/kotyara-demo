package com.kotyara.api.abstractcrud.service;

import java.util.List;

public interface AbstractService<Entity, DTO> {

  void create(DTO dto);

  List<Entity> getAll();

  Entity getById(int id);

  void remove(int id);

}
